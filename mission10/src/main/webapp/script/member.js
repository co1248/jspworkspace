function movieCheck() {
	if(document.frm.title.value == "") {
		alert("상품명을 입력하세요.");
		document.frm.name.pocus();
		return false;
	} else if (document.frm.price.value == "") {
		alert("가격을 입력하세요.");
		document.frm.price.pocus();
		return false;
	}  else if (isNaN(document.frm.price.value)) {
		alert("숫자만 입력하세요.");
		document.frm.price.pocus();
		return false;
	} else if (document.frm.director.value == "") {
		alert("감독을 입력하세요.");
		document.frm.director.pocus();
		return false;
	} else if (document.frm.actor.value == "") {
		alert("배우를 입력하세요.");
		document.frm.actor.pocus();
		return false;
	} else if (document.frm.synopsis.value == "") {
		alert("설명을 입력하세요.");
		document.frm.synopsis.pocus();
		return false;
	}
	return true;
}