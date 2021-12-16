'use strict';

let index = {
	init : function() {
		// 회원가입
		//this를 바인딩하기 위해 화샬표 함수 사용
		$("#btn-save").on("click", () => {
			let form = document.querySelector("#needs-validation");
			if(form.checkValidity() == false){
				console.log("회원가입 실패")
			} else {
				this.create();
			}
		});
		
		// 회원수정
		$("#btn-update").on("click", () => {
			let form = document.querySelector("#needs-validation");
			if(form.checkValidity() == false){
				console.log("회원가입 실패")
			} else {
				this.update();
			}
		})
	},
	
	create : function() {
		// JavaScript Object
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val(),
			nickname : $("#nickname").val()
		}
		
		$.ajax({
			// Http method
			type : "POST",
			// API 주소
			url : "/auth/api/v1/user",
			// JSON으로 변환
			data : JSON.stringify(data),
			// MIME 타입
			contentType : "application/json; charset=utf-8",
			// 응답 데이터
			dataType : "json"
		}).done(function(res) {
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(err) {
			alert(JSON.stringify(err));
		});
	},
	
	update : function() {
		let data = {
			id : $("#id").val(),
			password : $("#password").val(),
			email : $("#email").val(),
			nickname : $("#nickname").val()
		}
		
		$.ajax({
			// Http method
			type : "PUT",
			// API 주소
			url : "/api/v1/user",
			// JSON으로 변환
			data : JSON.stringify(data),
			// MIME 타입
			contentType : "application/json; charset=utf-8",
			// 응답 데이터
			dataType : "json"
		}).done(function(res) {
			alert("회원정보가 변경되었습니다.");
			location.href = "/";
		}).fail(function(err) {
			alert(JSON.stringify(err));
		});
	}
}

index.init();