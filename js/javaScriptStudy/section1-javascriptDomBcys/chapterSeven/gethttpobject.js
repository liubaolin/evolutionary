/**
 * Created by richey on 17-2-14.
 */
//获取Ajax对象
function getHttpObject() {
  if(typeof XMLHttpRequest == 'undefined'){
    XMLHttpRequest = function () {
      try {return new ActiveXObject("Msxml2.XMLHTTP.6.0");}
        catch (e){}
      try {return new ActiveXObject("Msxml2.XMLHTTP.3.0");}
        catch (e){}
      try {return new ActiveXObject("Msxml2.XMLHTTP");}
        catch (e){}
      return false;
    }
  }
  return new XMLHttpRequest();
}

window.onload = function () {
  var request = getHttpObject();
  if(request) {
    request.open("GET","example.txt",true);
    request.onreadystatechange = function () {
      if(request.readyState == 4) {
        var para = document.createElement("p");
        var txt = document.createTextNode(request.responseText);
        para.appendChild(txt);
        document.getElementById("new").appendChild(para);
      }
    }
    request.send();
  }else{
    alert("Sorry,your brower doesn\'t support XMLHttpRequest!")
  }
}