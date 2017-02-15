var codeValue = (window.sessionStorage.getItem("codeValue") || "请输入源代码").trim();
var jsSrc = window.sessionStorage.getItem("jsSrc");
var jsSrcNode = document.getElementById("codeTypejs");
if(codeValue && jsSrc){
  jsSrcNode.src = jsSrc;
}

var codeSelect = document.getElementById("codeTypeSelect");
function changeCodeType(index) {
  var selectVal = codeSelect.options[index].value;
  var jsSrc = "scripts\/" + selectVal + ".js";
  window.sessionStorage.setItem("jsSrc", jsSrc);
  if(selectVal == 'shBrushJScript'){
    window.sessionStorage.setItem("shBrush","brush: js;");
  }else if(selectVal == 'shBrushJava'){
    window.sessionStorage.setItem("shBrush","brush: java;");
  }else if(selectVal == 'shBrushXml'){
    window.sessionStorage.setItem("shBrush","brush: xml;");
  }
}

function toDestCode(sourceCode) {
  window.sessionStorage.setItem("codeValue", sourceCode);
  window.location.reload();
}

window.onload = function () {
  var shBrush = window.sessionStorage.getItem("shBrush");
  document.getElementById("preClass").class = shBrush;
  var codeNode = document.createTextNode(codeValue);
  document.getElementById("preClass").appendChild(codeNode);
  window.sessionStorage.clear();
}