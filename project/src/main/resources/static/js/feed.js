window.addEventListener("load",function(){

    // ajax 최초 요청
    let response_data = null;
    var curPage = 1;
    var cutPage = 20;
    // var keyword = null;
    $.ajax({
        url:"/api/content/feed",
        type:"get",
        data:{curPage : curPage, cutPage : cutPage,/* keyword : keyword*/}, // 클라이언트에서 서버로 넘기는 파라미터
        dataType:"json", // 응답데이터의 종류
        success:(respons) =>  {
            response_data = respons;
        },
        error:error_run,
        Async : false
    })

    let html = response_data.map(row => {
        const {review_seq, title, view_count, star, img_1, created_at} = row;
        return `
              <div class="col mb-1">
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
      <span className="stars">
                <i className="fa-solid fa-star star-active fa-xs"></i>
                <i className="fa-solid fa-star star-active fa-xs"></i>
                <i className="fa-solid fa-star star-active fa-xs"></i>
                <i className="fa-solid fa-star-half fa-xs star-active"></i>
                <span className="evaluation-count">(8)</span>
              </span>
      <br />
      <span className="cs-start-user">🧇 ${name}님이 작성</span>
      <br />
    </p>
      <div className="cs-tags mb-2">
        <button
                className="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>

        <button
                className="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>
        <button
                className="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>
        <button
                className="btn btn-tag btn-sm btn-rounded border cs-tag cs-more-tag"
                data-mdb-close="true"
        >
          ⚽️ 모임하기 좋아요
        </button>
      </div>
    </div>
    </div>
    </div>`    }).join('');
    feed_list.append(html);

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