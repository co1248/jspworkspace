Kakao.init("d55b38845c2bf5bee56bf835e25ac3df");
console.log(Kakao.isInitialized());
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      //토큰이 있으면
      Kakao.API.request({
        //로그아웃하고
        url: '/v1/user/unlink',
        success: function (response) {
          //console.log(response)
		location.replace("RailServlet?command=logout");
        },
        fail: function (error) {
          console.log(error);
        },
      })
      
      
    }
  }
//토큰도 삭제
      //Kakao.Auth.setAccessToken(undefined)

function kakaoLogin() {
	
	console.log(Kakao.isInitialized());
	Kakao.Auth.login({
		success: function(response) {
			window.Kakao.API.request({
				url: '/v2/user/me',
				success: function(response) {
					console.log(response)
					$('#response').append(response);
					id = response.id
					connected_at = response.connected_at
					kakao_account = response.kakao_account
					properties = response.properties

					/*$('#response').append(kakao_account);*/
					/*responsediv = "<h2>로그인 성공"
					responsediv += '<h4>id: ' + id + '<h4>'
					responsediv += '<h4>connected_at: ' + connected_at + '<h4>'*/
					email = "";
					gender = "";
					nickname = "";
					birthday = "";
					if (typeof kakao_account != 'undefined') {
						email = kakao_account.email;
						gender = kakao_account.gender;
						birthday = kakao_account.birthday;
						nickname = properties.nickname;
					}

				/*	responsediv += '<h4>email: ' + email + '<h4>'
					responsediv += '<h4>gender: ' + gender + '<h4>'
					responsediv += '<h4>nickname: ' + nickname + '<h4>'
					responsediv += '<h4>nickname: ' + birthday + '<h4>'
					$('#response').append(responsediv);*/
					console.log("유저 정보!");
					location.replace("http://localhost:8181/RailProject/RailServlet?command=join_form&name=" + nickname + "&email=" + email + "&birthday=" + birthday);




					if (typeof kakao_account == 'undefined') {
						console.log("넘어왔어요!22");


						location.replace("http://localhost:8181/RailProject/RailServlet?command=index");
					}
				},
				fail: function(error) {
					console.log(error)
				},
			})
		},
		fail: function(error) {
			console.log(error)
		},
	}
	)
}