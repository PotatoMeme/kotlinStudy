package com.potatomeme.modernandroid.docs


// 안드로이드 Http 통신

// 소켓 연결
// 소켓 : 네트워크 상의 두프로그램 사이에서 일어나는 양방향 통신중 한쪽의 엔드 포인트
// 클라이언트와 서버가 특정 포트를 통해 연결을 유지
// 주로 동양상 스트리밍이나 온라인 게임에서 주로 쓰임

// HTTP 연결
// HyperText Transfer Protocol 의 약자
// 80번 포트를 사용하여 웹상에서 정보를 주고받을 수 있는 프로토콜

// 동작방식
// 클라이언트가 서버에 헤더와 바디로 이루어진 메시지를 요청
// 서버는 이요청을 처리하고 응답코드와 함께 응답을 반환

// 특징
// Connectionless(비연결성, 소켓을 이용하기는 하지만 용건이 있을때만 연결을함 끝나면 연결이 끊김 )
// Stateless(서버가 클라이언트를 식별할수 없음)

// HTTP Method
// 주요 메소드
// GET : 리소스 조회
// POST : 요청 데이터 처리, 주로 데이터 등록에 사용
// PUT : 리소스를 대체, 해당 리소스가 없으면 생성
// PATCH : 리소스를 일부만 변경
// DELETE : 리소스 삭제

// 기타 메소드
// HEAD: GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 반환
// OPTIONS: 대상 리소스에 대한 통신 가능 옵션을 설명(주로 CORS에서 사용)
// CONNECT: 대상 자원으로 식별되는 서버에 대한 터널을 설정
// TRACE: 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행

// HTTP 상태코드
// 1xx (Informational): 요청이 수신되어 처리중

// 2xx (Successful): 요청 정상 처리
// 200 OK : 요청 성공
// 201 Created : 요청 성공해서 새로운 리소스가 생성됨
// 202 Accepted : 요청이 접수되었으나 처리가 완료되지 않았음
// 204 No Content : 서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음

// 3xx (Redirection): 요청을 완료하려면 추가 행동이 필요
// 301 Moved Permanently : 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음
// 302 Found : 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음
// 303 See Other : 리다이렉트시 요청 메서드가 GET으로 변경
// 304 Not Modified : 캐시를 목적으로 사용
// 307 Temporary Redirect : 리다이렉트시 요청 메서드와 본문 유지(요청 메서드를 변경하면 안된다.)
// 308 Permanent Redirect : 리다이렉트시 요청 메서드와 본문 유지(처음 POST를 보내면 리다이렉트도 POST 유지)

// 4xx (Client Error): 클라이언트 오류, 잘못된 문법등으로 서버가 요청을 수행할 수 없음
// 400 Bad Request : 클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음
// 401 Unauthorized : 클라이언트가 해당 리소스에 대한 인증이 필요함
// 403 Forbidden : 서버가 요청을 이해했지만 승인을 거부함
// 404 Not Found : 요청 리소스를 찾을 수 없음

// 5xx (Server Error): 서버 오류, 서버가 정상 요청을 처리하지 못함
// 500 Internal Server Error : 서버 문제로 오류 발생, 애매하면 500 오류
// 503 Service Unavailable : 서비스 이용 불가

// RESTful Api
// Representational State Transfer 의 약자
// 기준
// 클라이언트와 서버의 분리
// Stateless(서버가 클라이언트를 식별할수 없음)
// 캐시 처리가 가능해야함
// 시스템이 계층화(Layered) 되어있어야 함
// 일관성있는 인터페이스

// 안드로이드 http 클라이언트 라이브러리

// HttpClient (Apache, 6버전부터 사라짐)
// HttpUrlConnection ( 구글,기존의 URLConnection에 HTTP를 다루는데 필요한 메서드를 추가한 클래스)
// URL url = new URL("http:www.android.com/");
// HttpUrlConnection urlConnection = (HttpUrlConnection) url.openConnection();
// try{
//      InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//      readStream(in);
// } finally {
//      urlConnection.disconnect();
// }


// Volley ( HttpUrlConnection을 더 편하게 사용하기위해 랩핑한 라이브러리)
// val queue = Volley.newRequestQueue(this)
// val url = "http:www.android.com/"
// val stringRequest(Request.Method.GET,url,
//      Response.Listener<String> { response ->
//          textView.text = "Response is ${response.substring(0,500)}"
//      },
//      Response.ErrorListener { textView.text = "That didn't work!" })
// queue.add(stringRequest)

// OkHttp( 스케어 )
// OkHttpClient client = new OkHttpClient();
// String run(String url) throws IOException {
//      Request request = new Request.Builder()
//          .url(url)
//          .build();
//      try (Response response = client.newCall(request).execute() {
//          return response.body().string();
//      }
// }

// Retrofit ( OkHttp를 더 편하게 사용하기위해 랩핑한 라이브러리)
// public interface GitHubService {
//      @GET("users/{user}/repos")
//      Call<List<Repo>> listRepos(@Path("user") String user);
// }
// Retrofit retrofit = new Retrofit.Builder
//      .baseUrl("https://api.github.com/")
//      .build();
// GitHubService service = retrofit.create(GitHubService.class);
// Call<List<Repo>> repos = service.listRepos("octocat");

//                   Volley  vs  Retrofit
// Automatic           no          yes
// Caching             yes         no
// Retrying            yse         no
// PostRequests
// & Multipart uploads yes         partly
// Image Loading       Built-in    no