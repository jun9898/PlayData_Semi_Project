window.addEventListener("load",async function(){
    // ajax 최초 요청
    var param = null;
    var curPage = 1;
    var cutPage = 20;
    var keyword = "";
    var searchType = "";
    param = {curPage : curPage, cutPage : cutPage, keyword : keyword, searchType : searchType}
    try{
        let res =  await axios.get("/api/content/feed", {params : param})
        let html = res.data.map(row => {
            const {review_seq, title, name, view_count, star, img_1, created_at} = row;
            return `
              <div class="col mb-1" OnClick="location.href ='/content/feed/${review_seq}'">
              <div class="card cs-feed-card">
              <img
                src="https://mdbcdn.b-cdn.net/img/new/standard/nature/182.webp"
                class="card-img-top img-fluid"
                alt="Sunset Over the Sea"
              />
              <div class="card-body p-2">
              <p class="card-text">
              <span class="title"><b>${title}</b></span>
      <br />
      <span class="categroy-text">양식, 멕시코</span>
      <span class="stars">
                <i class="fa-solid fa-star star-active fa-xs"></i>
                <i class="fa-solid fa-star star-active fa-xs"></i>
                <i class="fa-solid fa-star star-active fa-xs"></i>
                <i class="fa-solid fa-star-half fa-xs star-active"></i>
                <span class="evaluation-count">(8)</span>
              </span>
      <br />
      <span class="cs-start-user"><b>${name}</b></span>
      <br />
    </p>
      <div class="cs-tags mb-2">
        <button
                class="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>

        <button
                class="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>
        <button
                class="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>
        <button
                class="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>
      </div>
    </div>
    </div>
    </div>`    }).join('');
        $('#feed_list').append(html);


    } catch (e){

    }





    function error_run(obj,resmsg,errormsg) {
        console.log("오류발생");
        console.log("obj = " + obj);
        console.log("resmsg = " + resmsg);
        console.log("errormsg = " + errormsg);
    }

    /* 검색 대상을 정하는 버튼의 전체 버튼을 눌렀을때 */
    $("#feed-selected-all").on("click", () => {
        // 버튼의 "selected" 클래스를 토글
        if ($("#feed-selected-all").hasClass("selected")) {
            keyword = ""; // 키워드 값을 ""로 설정
            // 이미 선택된 상태인 경우, 클래스 제거
            $("#feed-selected-all").removeClass("selected");
        } else {
            // 선택되지 않은 상태인 경우, 클래스 추가
            keyword = "all"; // 키워드 값을 "all"로 설정
            $("#feed-selected-all").addClass("selected");
            $("#feed-selected-following").removeClass("selected");
        }
    });

    /* 검색 대상을 정하는 버튼의 친구만 버튼을 눌렀을때 */
    $("#feed-selected-following").on("click", () => {
        // 버튼의 "selected" 클래스를 토글
        if ($("#feed-selected-following").hasClass("selected")) {
            keyword = ""; // 키워드 값을 ""로 설정
            // 이미 선택된 상태인 경우, 클래스 제거
            $("#feed-selected-following").removeClass("selected");
        } else {
            // 선택되지 않은 상태인 경우, 클래스 추가
            keyword = "following"; // 키워드 값을 "all"로 설정
            $("#feed-selected-following").addClass("selected");
            $("#feed-selected-all").removeClass("selected");
        }
    });

/*
    $("#feed-selected-following").on("click", () => {
        $("#feed-auto-complete")[0].classList.add("cs-autocomplete-show");
    });
*

    $("#feed-search").on("click", () => {
        $("#feed-auto-complete")[0].classList.add("cs-autocomplete-show");
    });
    /* 포커스 아웃 */
    $("#feed-search").on("blur", () => {
        $("#feed-auto-complete").removeClass("cs-autocomplete-show");
    });

    $("button[data-id='feed-btn']").addClass("disabled");
    let index = -1;
    const ARROW_UP = 38;
    const ARROW_DOWN = 40;
    const ENTER = 13;
    $("#feed-search").on("keydown", (e) => {
      let item_lth = $(".cs-autocomplete-item").length;
      switch (e.keyCode) {
        case ARROW_DOWN:
          if (index < item_lth) index++;
          $(".cs-autocomplete-item")[index].classList.add("active");
          e.target.value = $(".cs-autocomplete-item")[index].innerText;
          $(".cs-autocomplete-item")[index - 1].classList.remove("active"); // 추후 오류 처리 필요
          break;
        case ARROW_UP:
          if (index > 0) index--;
          $(".cs-autocomplete-item")[index].classList.add("active");
          e.target.value = $(".cs-autocomplete-item")[index].innerText;
          $(".cs-autocomplete-item")[index + 1].classList.remove("active"); // 추후 오류 처리 필요
          break;
        case ENTER:
            keyword = ""
          alert("search");
          document.body.focus();
          $(".cs-autocomplete-item").removeClass("active");
          $("#feed-auto-complete").removeClass("cs-autocomplete-show");
          break;
      }
      console.log(e.keyCode);
    });

    $(".cs-autocomplete-item").on("click", (e) => {
      console.log(e, e.target.innerText);
      $("#feed-search").val(e.target.innerText);
      $(".cs-autocomplete-item").removeClass("active");
      $("#feed-auto-complete").removeClass("cs-autocomplete-show");
    });
});