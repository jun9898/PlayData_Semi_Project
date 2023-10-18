window.addEventListener("load",async function(){
    // ajax 최초 요청
    let response_data = null;
    var curPage = 1;
    var cutPage = 20;
    var keyword = "";
    var searchType = "";
    data = {curPage : curPage, cutPage : cutPage, keyword : keyword, searchType : searchType}
    let res =  await axios.get("/api/content/feed?curPage=1&cutPage=5&keyword=&searchType=")

    $.ajax({
        url:"/api/content/feed",
        type:"get",
        data,// 클라이언트에서 서버로 넘기는 파라미터
        dataType:"json", // 응답데이터의 종류
        success:(respons) =>  {
            console.log(respons)
            response_data = respons;
        },
        error:error_run,
        async : false
    })
    let html = response_data.map(row => {
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

    function error_run(obj,resmsg,errormsg) {
        console.log("오류발생");
        console.log("obj = " + obj);
        console.log("resmsg = " + resmsg);
        console.log("errormsg = " + errormsg);
    }

    $("#feed-search").on("click", () => {
        $("#feed-auto-complete")[0].classList.add("cs-autocomplete-show");
    });
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