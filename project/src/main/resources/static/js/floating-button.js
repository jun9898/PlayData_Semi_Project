document.addEventListener('DOMContentLoaded', function() {
  
    const floatingBtnContainer = document.querySelector('.cs-floating-btn-container');
    const floatingBtn = floatingBtnContainer.querySelector('.cs-floating-btn');
    const subButtons = floatingBtnContainer.querySelector('.cs-floating-sub-buttons');
  
    // 메인 버튼 클릭 시
    floatingBtn.addEventListener('click', function() {
        floatingBtnContainer.classList.toggle('cs-active');
    });
  
    // 다른 부분 클릭 시
    document.addEventListener('click', function(event) {
        if (!floatingBtnContainer.contains(event.target)) {
            floatingBtnContainer.classList.remove('cs-active');
        }
    });
  });