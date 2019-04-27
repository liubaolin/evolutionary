/**
 * Created by richey on 17-4-17.
 */
import Rx from 'rxjs/Rx';

const observable = Rx.Observable.create(observer => {
  observer.onNext('richey');
  observer.onNext('kelly');
  observer.onNext('dalia');
  observer.onCompleted('');//成功完成
})

const observer = Rx.Observer.create(
  function onNext(x){console.log('Next:'+x);},
  function onError(err){console.log('Erroe:'+err);},
  function onCompleted() {console.log('Completed')}
)

function get(url) {
  return Rx.Observable.create(observer => {
    let req = new XMLHttpRequest();
    req.open('GET', url);
    req.onload = function () {
      if(req.status == 200) {
        observer.onNext(req.response);
        observer.onCompleted();
      }else{
        observer.onError(new Error(req.statusText));
      }
      
    }
    req.onerror = function () {
      observer.onErrr(new Erroe('Unknow Error'));
    }
    req.send();
  })
}

var source = get("/api/contents.json");

source.subscribe(
  function onNext(x) { console.log('Result: ' + x); },
  function onError(err) { console.log('Error: ' + err); },
  function onCompleted() { console.log('Completed'); }
);

Rx.DOM.get('/api/contents.json').subscribe(
  function onNext(data) {console.log(data.response)},
  function onError(err) {console.log(err)}
)

Rx.Observable.from(['richey','kelly','dalia']).subscribe(
  function onNext(x) {
    console.log('next:' + x)
  },
  function onError(err) {
    console.log("Error:" + err);

  },
  function onCompleted() {
    console.log("completed");
  }
)

const allMoves = Rx.Observable.fromEvent(document, 'mousemove');
allMoves.subscribe(function (e) {
  console.log(e.clientX, e.clientY);
})

const movesOnTheRight = allMoves.filter(function (e) {
  return e.clientX > window.innerWidth / 2;
})

const movesOnTheLeft = allMoves.filter(function (e) {
  return e.clientX < window.innerWidth / 2;
})

movesOnTheRight.subscribe(function (e) {
  console.log("Mouse is on the right " + e.clientX);
})

movesOnTheLeft.subscribe(function (e) {
  console.log("Mouse is on the left " + e.clientX);
})