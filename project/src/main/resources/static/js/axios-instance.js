
// 요청 인터셉터 추가하기
axios.defaults.paramsSerializer = params => {
    return Qs.stringify(params);
}
axios.interceptors.request.use(function (config) {
    // 요청이 전달되기 전에 작업 수행
    // config = {...config,paramsSerializer}
    return config;
}, function (error) {
    // 요청 오류가 있는 작업 수행
    return Promise.reject(error);
});

// 응답 인터셉터 추가하기
axios.interceptors.response.use(function (response) {
    // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 데이터가 있는 작업 수행
    return response;
}, function (error) {
    // 2xx 외의 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    let status_code = error?.response?.status;

    if(status_code === 401 && `${location.host}${location.pathname}` !== `${location.host}/login`){
        alert('세션이 만료되어 로그인 페이지로 이동합니다.');
        location.href = '/login';
    }
    // 응답 오류가 있는 작업 수행
    return Promise.reject(error);
});