const TEST_DATA = [
    {
        market_name : "가게이름",
        review_count : 8,
        market_img_url : "img.jpg",
        market_avg_star : 4.5,

    },
];
let debugCall = null;
window.addEventListener('load', ()=>{

    const MAP_INIT_LEVEL = 3;
    const MAP_INIT_Y = 33.450701;
    const MAP_INIT_X = 126.570667;
    const MAP_CLUSTER_LEVEL = 12;

    let map_options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(MAP_INIT_Y, MAP_INIT_X), //지도의 중심좌표.
        level: MAP_INIT_LEVEL, //지도의 레벨(확대, 축소 정도)
    };
    function Map(options){
        this.map = null;
        this.$div_map = $("#maps");
        this.Init(options);
    }
    Map.prototype.Init = function(options){
        try{
            this.map = new kakao.maps.Map(this.$div_map[0],options);
        }catch(e){
            alert(`지도 초기화에 실패하였습니다. 관리자에게 문의해 주세요.`);
        }
        return this;
    }
    Map.prototype.AddEvent = function(){
        return this;
    }
    Map.prototype.ClearMarker = function(){
        // let marker = new kakao.maps.Marker({
        //     position: markerPosition
        // });
        // marker.setMap(null);
        return this;
    }
    Map.prototype.DrawMarkerView = function(data){

    }
    Map.prototype.DrawClusterView = function(data){

    }
    Map.prototype.GetMapInfo = function(){
        let bounds = this.map.getBounds();
        let {ha,oa,pa,qa} = bounds;
        let center = this.map.getCenter();
        let level = this.map.getLevel();
        let mapTypeId = this.map.getMapTypeId();
        let swLatLng = bounds.getSouthWest();
        let neLatLng = bounds.getNorthEast();
        let rect = `${ha},${qa},${oa},${pa}`; // `${qa},${ha},${pa},${oa}`; // `${pa},${oa},${qa},${ha}`;
        return {
            bounds,center,level,mapTypeId,swLatLng,neLatLng,rect
        };
    }
    Map.prototype.PrintInfo = function(){
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


    function App(map_instance){
        this.map_instance = map_instance
        this.tag_instance = null;
        this.market_list = [];

        this.$button_active_sidebar =  $(".cs-bar-cover .cs-btn-active");
        this.$button_deactive_sidebar = $(".cs-bar-cover .cs-btn-deactive");
        this.$input_keyword = $("#keyword");
        this.$button_search = $("#map-search-btn");
        this.debounce_search = null; // 디바운싱용 변수.

        this.AddEvent().Init();
    }
    App.prototype.Init =  async function(){
        await this.ContentReload();
        this.tag_instance = new Tag(await this.GetTagList());
        return this;
    }
    App.prototype.AddEvent = function(){
        this.$button_active_sidebar.on("click",(e)=>{
            $(".cs-bar-cover").addClass("active");
        });
        this.$button_deactive_sidebar.on("click",(e)=>{
            $(".cs-bar-cover").removeClass("active");
        });
        this.$input_keyword.on("keyup",async (e)=>{
            if(e.key !== 'Enter')
                return;
            this.DebounceReloadCall();
        });
        this.$button_search.on("click",()=>{ this.DebounceReloadCall();})
        return this;
    }
    App.prototype.DebounceReloadCall = function(){
        if(this.debounce_search)
            clearTimeout(this.debounce_search)
        this.debounce_search = setTimeout(()=>{ this.ContentReload() },1000);
    }
    App.prototype.ContentReload = async function(e){
        let map_level = MAP_INIT_LEVEL;
        if(e?.level){
            map_level = e.level
        }else{
            map_level = this.map_instance.GetMapInfo()?.level || MAP_INIT_LEVEL;
        }
        this.map_instance.ClearMarker();
        this.market_list = await this.GetMarketList();
        if(map_level >= MAP_CLUSTER_LEVEL)
            this.map_instance.DrawClusterView(await this.GetMarketAreaCount());
        else
            this.map_instance.DrawMarkerView(this.market_list);
        new Market(this.market_list);
    }
    App.prototype.GetMarketList = async function(){
        let {bounds,center,level,mapTypeId,swLatLng,neLatLng,rect} = this.map_instance.GetMapInfo();

        let query = this.$input_keyword.val()?.trim() || "";
        let params = {
            rect, query, latitude : center.La, longitude : center.Ma,level,
        };
        try {
            return await axios.get("/api/content/map",{params})?.data || [];
        }catch(e){
            console.log(e);
        }
    }
    App.prototype.GetMarketAreaCount = async function(){
        try{
            await axios.get("/api/content/map/area-count");
        }catch(e){
            console.log(e);
        }
    }
    App.prototype.GetTagList = async function(){
        try{
            return await axios.get("/api/content/tag")?.data;
        }catch(e){
            console.log(e);
        }
    }

    function Market(market_list){
        console.log(market_list)
        this.$div_market_list = $("#market-list");
        this.data = market_list;
        this.Init();
        this.DrawView();
    }
    Market.prototype.Init = function(){
        if(!this.data)
            throw new Error("데이터가 없습니다.");
    }
    Market.prototype.DrawView = function(){
        let html ='';
        if((this.data?.length || 0) === 0){
            html =`<div class="">데이터가 없습니다.</div>`;
        }
        html = this.data.map(()=>{
        `
        <div class="card m-1" >
          <a href="#">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                  src="${AppProperty.path}/"
                  alt="Trendy Pants and Shoes"
                  class="img-fluid rounded-start"
              />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">
                    
                </p>
                <p class="card-text">
                  <small class="text-muted">
                       
                    </small>
                </p>
              </div>
            </div>
          </div>
          </a>
        </div>
        `}).join('');
        this.$div_market_list.html(html);
    }

    function Tag(tag_list){
        this.$div_tag_list = $("#market-list");
        this.data = tag_list;
        this.Init();
        this.DrawView();
    }
    Tag.prototype.Init = function(){
        if(!this.data)
            throw new Error("데이터가 없습니다.");
    }
    Tag.prototype.DrawView = function(){
        let html ='';
        if((this.data?.length || 0) === 0){
            html =`<div class="">데이터가 없습니다.</div>`;
        }
        html = this.data.map((row,index)=>{
            let {code,cd_name} = row;
            `
            <div class="d-inline p-0 mb-1">
              <button class="btn btn-tag btn-sm btn-rounded border btn-secondary selected text-truncate"
                      data-mdb-close="true" data-code="${code}">
               ${cd_name}
              </button>
            </div>
        `}).join('');
        this.$div_tag_list.html(html);
    }

    let map_instance = new Map(map_options);
    let app = new App(map_instance);
    new Market(TEST_DATA)
    document.addEventListener('change-map-level',async (e)=>{
        await app.ContentReload(e);
    });
    document.addEventListener('debug-map',()=>{
        console.log(map_instance.GetMapInfo());
    });



    debugCall = ()=>{document.dispatchEvent(new CustomEvent("debug-map"))};


    // window.dispatchEvent(new Event("debug-map"));
});