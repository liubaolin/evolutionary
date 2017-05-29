/**
 * Created by richey on 17-4-17.
 */
//------------------------Observer模式--------------------------
function Producer(){
  this.listeners = [];
}

Producer.prototype.add = function (listener) {
  this.listeners.push(listener);
}

Producer.prototype.remove = function (listener) {
  var index = this.listeners.indexOf(listener);
  this.listeners.splice(index, 1);
}

Producer.prototype.notify = function (message) {
  this.listeners.forEach(function (listener) {
    listener.update(message);
  })
}

var listener1 = {
  update:function (message) {
    console.log("listener1 received:", message);
    
  }
}

var listener2 = {
  update:function (message) {
    console.log("listener2 received:", message);
  }
}

var notifer = new Producer();
notifer.add(listener1);
notifer.add(listener2);
notifer.notify("hello world!");


//------------------------Iterator模式--------------------------

function IteratorOnMultiples(arr,divisor) {
  this.cursor = 0;
  this.array = arr;
  this.divisor = divisor || 1;
}

IteratorOnMultiples.prototype.next = function () {
  while (this.cursor<this.array.length) {
    var value = this.array[this.cursor++];
    if(value%this.divisor === 0) {
      return value;
    }
  }
}

IteratorOnMultiples.prototype.hasNext = function () {
  var cur = this.cursor;
  while (this.cursor<this.array.length) {
    var value = this.array[cur++];
    if(value%this.divisor === 0) {
      return true;
    }
  }
  return false;
}

var consumer = new IteratorOnMultiples([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3);
console.log(consumer.next(), consumer.hasNext());
console.log(consumer.next(), consumer.hasNext());
console.log(consumer.next(), consumer.hasNext());













