function productCheck() {
	if(document.frm.name.value == "") {
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
	}
	return true;
}