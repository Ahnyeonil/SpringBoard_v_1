'use strict';

let index = {
    init: function () {
        $("#btn-create").on("click", () => {
            this.create();
        });

		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
		
		$("#btn-update").on("click", () => {
			this.update();
		});
    },

    create : function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/v1/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("게시글 작성이 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

	deleteById : function () {
		let id = $("#id").text();
		
		$.ajax({
			type : "DELETE",
			url : "/api/v1/board/" + id,
			dataType : "json"
		}).done(function(res) {
			alert("게시글이 삭제되었습니다.");
			location.href = "/";
		}).fail(function(err){
			alert(JSON.stringify(err));
		});
	},
	
	update : function () {
		let data = {
			title : $("#title").val(),
			content : $("#content").val()
		};
		
		let id = $("#id").text();
		$.ajax({
			type : "PUT",
			url : "/api/v1/board/" + id,
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function (res){
			alert("게시글이 수정되었습니다.");
			location.href = "/";
		}).fail(function (err) {
			alert(JSON.stringify(err));
		});
	}
}
index.init();