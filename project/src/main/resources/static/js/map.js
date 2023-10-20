const TEST_DATA = [
    {
        market_name: "가게이름",
        review_count: 8,
        market_img_url: "img.jpg",
        market_avg_star: 4.5,

    },
];
let debugCall = null;
window.addEventListener('load', () => {

    const MAP_INIT_LEVEL = 13;
    const MAP_INIT_Y = 35.47311106681065;
    const MAP_INIT_X = 126.9569852763799;
    const MAP_CLUSTER_LEVEL = 13;
    let map_options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(MAP_INIT_Y, MAP_INIT_X), //지도의 중심좌표.
        level: MAP_INIT_LEVEL, //지도의 레벨(확대, 축소 정도)
    };


    function Map(options) {
        this.map = null;
        this.$div_map = $("#maps");

        this.marker_list = [];
        this.Init(options);
        this.AddEvent();
    }

    Map.prototype.Init = function (options) {
        try {
            this.map = new kakao.maps.Map(this.$div_map[0], options);
        } catch (e) {
            alert(`지도 초기화에 실패하였습니다. 관리자에게 문의해 주세요.`);
        }

        return this;
    }
    Map.prototype.AddEvent = function () {
        kakao.maps.event.addListener(this.map, 'zoom_changed', function () {
            document.dispatchEvent(new CustomEvent("change-map-level"));
        });
        return this;
    }
    Map.prototype.ClearMarker = function () {
        this.marker_list.map(marker=>{
            marker.setMap(null);
        })
        return this;
    }
    Map.prototype.DrawMarkerView = function (data) {
        console.log('마커로 표시..')
        let map_positions = data.map((row, index) => {
            let {
                address_name, distance, market_id,
                market_img,
                market_name,
                market_seq,
                review_count,
                writer_name,
                star_avg,
                x, y
            } = row;
            return {
                content: `<div>
                                 <img src="${market_img}" style="height:50px;" >
                                    <h3>${market_name}</h3>
                                    <p>
                                    ${review_count > 0 ?
                                        `별점 평균 : ${star_avg}</br>리뷰 개수 : ${review_count}`
                                        :   `작성된 리뷰가 없습니다.`}
                                    </p>
                                    <button><a href="/content/feed/write?market_seq=${market_seq}">리뷰작성</a></button>
                                    <h4><a href="/market/${market_seq}">${location.origin}/market/${market_seq}</a></h4>
                            </div>`,
                latlng: new kakao.maps.LatLng(y, x)
            }
        });
        this.marker_list =  map_positions.map((row,index)=>{
            let {latlng, content } = row;
            // 마커를 생성합니다
            let marker = new kakao.maps.Marker({
                map: this.map, // 마커를 표시할 지도
                position: latlng // 마커의 위치
            });

            // 마커에 표시할 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: content // 인포윈도우에 표시할 내용
            });

            // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
            // 이벤트 리스너로는 클로저를 만들어 등록합니다
            // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
            kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(this.map, marker, infowindow));
            kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow))
            return marker;
        });

        // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
        function makeOverListener(map, marker, infowindow) {
            return function () {
                infowindow.open(map, marker);
            };
        }

        // 인포윈도우를 닫는 클로저를 만드는 함수입니다
        function makeOutListener(infowindow) {
            return function () {
                infowindow.close();
            };
        }

    }
    Map.prototype.DrawClusterView = function (data) {
        // console.log('클러스터로 표시..')
        // var clusterer = new kakao.maps.MarkerClusterer({
        //     map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        //     averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        //     minLevel: 10 // 클러스터 할 최소 지도 레벨
        // });
        //
        // // 데이터를 가져오기 위해 jQuery를 사용합니다
        // // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
        // $.get("/download/web/data/chicken.json", function(data) {
        //     // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        //     // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        //     var markers = $(data.positions).map(function(i, position) {
        //         return new kakao.maps.Marker({
        //             position : new kakao.maps.LatLng(position.lat, position.lng)
        //         });
        //     });
        //
        //     // 클러스터러에 마커들을 추가합니다
        //     clusterer.addMarkers(markers);
        // });

    }
    Map.prototype.GetMapInfo = function () {
        let bounds = this.map.getBounds();
        let {ha, oa, pa, qa} = bounds;
        let center = this.map.getCenter();
        let level = this.map.getLevel();
        let mapTypeId = this.map.getMapTypeId();
        let swLatLng = bounds.getSouthWest();
        let neLatLng = bounds.getNorthEast();
        let rect = `${ha},${qa},${oa},${pa}`; // `${qa},${ha},${pa},${oa}`; // `${pa},${oa},${qa},${ha}`;
        return {
            bounds, center, level, mapTypeId, swLatLng, neLatLng, rect,
            ha, qa, oa, pa
        };
    }
    Map.prototype.PrintInfo = function () {
        let map = this.map;
        let center = map.getCenter();
        // 지도의 현재 레벨을 얻어옵니다
        var level = map.getLevel();
        // 지도타입을 얻어옵니다
        var mapTypeId = map.getMapTypeId();
        // 지도의 현재 영역을 얻어옵니다
        var bounds = map.getBounds();
        // 영역의 남서쪽 좌표를 얻어옵니다
        var swLatLng = bounds.getSouthWest();
        // 영역의 북동쪽 좌표를 얻어옵니다
        var neLatLng = bounds.getNorthEast();
        // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
        var boundsStr = bounds.toString();
        var message = '지도 중심좌표는 위도 ' + center.getLat() + ', <br>';
        message += '경도 ' + center.getLng() + ' 이고 <br>';
        message += '지도 레벨은 ' + level + ' 입니다 <br> <br>';
        message += '지도 타입은 ' + mapTypeId + ' 이고 <br> ';
        message += '지도의 남서쪽 좌표는 ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + ' 이고 <br>';
        message += '북동쪽 좌표는 ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' 입니다';
        console.log(message)
    }


    function App(map_instance) {
        this.map_instance = map_instance
        this.tag_instance = null;
        this.market_list = [];

        this.$button_active_sidebar = $(".cs-bar-cover .cs-btn-active");
        this.$button_deactive_sidebar = $(".cs-bar-cover .cs-btn-deactive");
        this.$input_keyword = $("#keyword");
        this.$button_search = $("#map-search-btn");
        this.debounce_search = null; // 디바운싱용 변수.

        this.AddEvent().Init();
    }

    App.prototype.Init = async function () {
        this.tag_instance = new Tag(await this.GetTagList());
        await this.ContentReload();
        return this;
    }
    App.prototype.AddEvent = function () {
        this.$button_active_sidebar.on("click", (e) => {
            $(".cs-bar-cover").addClass("active");
        });
        this.$button_deactive_sidebar.on("click", (e) => {
            $(".cs-bar-cover").removeClass("active");
        });
        this.$input_keyword.on("keyup", async (e) => {
            if (e.key !== 'Enter')
                return;
            this.DebounceReloadCall();
        });
        this.$button_search.on("click", () => {
            this.DebounceReloadCall();
        })
        return this;
    }
    App.prototype.DebounceReloadCall = function () {
        if (this.debounce_search)
            clearTimeout(this.debounce_search)
        this.debounce_search = setTimeout(() => {
            this.ContentReload()
        }, 1000);
    }
    App.prototype.ContentReload = async function (e) {
        let map_level = MAP_INIT_LEVEL;
        if (e?.level) {
            map_level = e.level
        } else {
            map_level = this.map_instance.GetMapInfo()?.level || MAP_INIT_LEVEL;
        }
        this.map_instance.ClearMarker();
        this.market_list = await this.GetMarketList();
        if (map_level >= MAP_CLUSTER_LEVEL)
            this.map_instance.DrawClusterView(await this.GetMarketAreaCount());
        else
            this.map_instance.DrawMarkerView(this.market_list);
        new Market(this.market_list);
    }
    App.prototype.GetMarketList = async function () {
        let {center, level, rect, ha, qa, oa, pa} = this.map_instance.GetMapInfo();
        let tags = this.tag_instance.getSelectedTagValues();
        let query = this.$input_keyword.val()?.trim() || "";
        let params = {
            rect, query, latitude: center.La, longitude: center.Ma, level, tags,
            ha, qa, oa, pa
        };
        try {
            return (await axios.get("/api/content/map", {params}))?.data || [];
        } catch (e) {
            console.log(e);
        }
    }
    App.prototype.GetMarketAreaCount = async function () {
        try {
            return (await axios.get("/api/content/map/area-count"))?.data || [];
        } catch (e) {
            console.error(e);
        }
    }
    App.prototype.GetTagList = async function () {
        try {
            return (await axios.get("/api/content/tag"))?.data || [];
        } catch (e) {
            console.error(e);
        }
    }

    function Market(market_list) {
        this.$div_market_list = $("#market-list");
        this.data = market_list;
        this.Init();
        this.DrawView();
    }

    Market.prototype.Init = function () {
        if (!this.data)
            throw new Error("데이터가 없습니다.");
    }
    Market.prototype.DrawView = function () {
        let html = '';
        if ((this.data?.length || 0) === 0) {
            html = `<div class="">데이터가 없습니다.</div>`;
        }
        html = this.data.map((row) => {
            let {
                address_name, distance, market_id,
                market_img,
                market_name,
                market_seq,
                review_count,
                writer_name,
                star_avg,
                x, y
            } = row;
            return `
        <div class="card m-1" >
          <a href="/content/feed/${market_seq}">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                  src="${AppProperty.path}${market_img}"
                  alt="${address_name}"
                  class="img-fluid rounded-start"
              />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">${market_name}</h5>
                <p class="card-text">
                      ${review_count > 0 ?
                    `별점 평균 : ${star_avg}</br>리뷰 개수 : ${review_count}`
                    :   `작성된 리뷰가 없습니다.`}
                </p>
                <p class="card-text">
                  <small class="text-muted">
                       ${address_name}
                    </small>
                </p>
              </div>
            </div>
          </div>
          </a>
        </div>
        `
        }).join('');
        this.$div_market_list.html(html);
    }


    function Tag(tag_list) {
        this.$div_tag_list = $(".cs-tag-section");
        this.data = tag_list;
        this.Init();
        this.DrawView();
        this.AddEvent();
    }

    Tag.prototype.Init = function () {
        if (!this.data || !this?.data instanceof Array)
            throw new Error("태그 데이터가 없습니다.");
    }
    Tag.prototype.AddEvent = function () {
        // btn swiching
        this.$div_tag_list.on("click", (e) => {
            let btn = e.target.closest('button[name=search-tags]');
            if (!btn)
                return;
            if (btn.classList.contains('selected')) {
                btn.classList.remove('selected');
            } else {
                btn.classList.add('selected');
            }
        })
    }
    Tag.prototype.DrawView = function () {
        let html = '';
        if ((this.data?.length || 0) === 0) {
            html = ``;
        }
        this.data.map((row, index) => {
            let {code, cd_name} = row;
            html += `
            <div class="d-inline p-0 mb-1">
              <button name="search-tags"  class="btn btn-tag btn-sm btn-rounded border btn-secondary text-truncate"
                      data-mdb-close="true" value="${code}">
               ${cd_name}
              </button>
            </div>
        `
        }).join('');
        this.$div_tag_list.html(html);
    }
    Tag.prototype.getSelectedTagValues = function () {
        let selected_tags_ele = this.$div_tag_list.find("[name=search-tags].selected");
        return Array.prototype.map.call(selected_tags_ele, e => e.value);
    }

    let map_instance = new Map(map_options);
    let app = new App(map_instance);

    document.addEventListener('change-map-level', async (e) => {
        await app.ContentReload(e);
    });
    document.addEventListener('debug-map', () => {
        console.log(map_instance.GetMapInfo());
    });


    debugCall = () => {
        document.dispatchEvent(new CustomEvent("debug-map"))
    };

    // window.dispatchEvent(new Event("debug-map"));
});