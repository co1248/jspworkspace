function joinCheck(){
   if(document.frm.id.value == ""){
      alert("아이디를 입력해주세요");
      document.frm.id.focus();
      return false;
   }else if(document.frm.pass.value == ""){
      alert("비밀번호를 입력해주세요");
      document.frm.pass.focus();
      return false;
   }else if(document.frm.name.value == ""){
      alert("이름을 입력해주세요");
      document.frm.name.focus();
      return false;
   }else if(document.frm.age.value == ""){
      alert("나이를 입력해주세요");
      document.frm.age.focus();
      return false;
   }else if(document.frm.gender.value == ""){
      alert("성별를 입력해주세요");
      document.frm.gender.focus();
      return false;
   }else if(document.frm.email.value == ""){
      alert("메일를 입력해주세요");
      document.frm.email.focus();
      return false;
   }else{
      document.frm.submit();
   }
}