function joinCheck() {
	if (document.frm.id.value.length == 0) {
      alert("아이디를 써주세요");
      frm.id.focus();
      return false;
    }
	if (document.frm.password.value == "") {
      alert("암호는 반드시 입력해야 합니다.");
      frm.password.focus();
      return false;
    }
	if (document.frm.name.value.length == 0) {
      alert("이름을 써주세요");
      frm.name.focus();
      return false;
    }
	if (document.frm.age.value.length == 0) {
      alert("나이를 써주세요.");
      frm.age.focus();
      return false;
    }
	if (document.frm.gender.value.length == 0) {
      alert("성별을 선택해주세요.");
      frm.gender.focus();
      return false;
    }
	if (document.frm.email.value.length == 0) {
      alert("이메일 주소를 써주세요.");
      frm.email.focus();
      return false;
    }
    return true;
}