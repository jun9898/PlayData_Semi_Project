window.addEventListener('load',()=>{
    var container = document.getElementById("maps"); //지도를 담을 영역의 DOM 레퍼런스
    console.log(container,kakao.maps)
    var options = {
      //지도를 생성할 때 필요한 기본 옵션
      center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
      level: 3, //지도의 레벨(확대, 축소 정도)
    };

    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
    $(".cs-bar-cover .cs-btn-active").on("click",(e)=>{
      $(".cs-bar-cover").addClass("active");
    });
    $(".cs-bar-cover .cs-btn-deactive").on("click",(e)=>{
      $(".cs-bar-cover").removeClass("active");
    })
  });