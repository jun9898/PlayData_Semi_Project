window.addEventListener("load",function(){

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