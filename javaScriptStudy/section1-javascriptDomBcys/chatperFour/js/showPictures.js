/**
 * Created by richey on 17-2-13.
 */
var placeHolder = document.getElementById("placeHolder");
var description = document.getElementById("description");
function showPic(picMode) {
  var target = picMode.href;
  var despText = picMode.title;
  placeHolder.setAttribute("src", target);
  description.innerText = despText;
  
}
window.onload = function () {
  document_body = document.getElementsByTagName("body")[0];
  alert(document_body.childNodes.length);
}