function getStudentInfo() {
  $.ajax({
    url: "/student",
    type: "get",
    dataType: "json",
    success: function(data) {
      analyseTranslation(data)
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      alert(XMLHttpRequest.status);
      alert(XMLHttpRequest.readyState);
      alert(textStatus);
    },
  });
}

getStudentInfo();

function addTr(text) {
  return "<tr>" + text + "</tr>";
}

function addTd(text) {
  return "<td>" + text + "</td>";
}

function addButton(id) {
  return "<button type=\"button\" class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#addStudent\">增加</button>\
          <button type=\"button\" class=\"btn btn-warning btn-xs\" data-toggle=\"modal\" data-target=\"#modStudent\"  onclick=\"modStudentInit(" + id + ")\">修改</button>\
          <button type=\"button\" class=\"btn btn-danger btn-xs\" data-toggle=\"modal\" data-target=\"#delStudent\" onclick=\"delStudentInit(" + id + ")\">删除</button>";
}

function analyseTranslation(data) {
  // console.log(data);
  
  var text = "";
  $.each(data, function(key, student) {
    var td = "";
    td += addTd(student.sid);
    td += addTd(student.sname);
    td += addTd(student.score);
    td += addTd(student.address);
    td += addTd(addButton(student.sid));
    text += addTr(td);
  });
  
  $('#student-show').empty();
  $('#student-show').append(text);
}

function addStudent() {
  var sname = $('#addSname').val();
  var score = $('#addScore').val();
  var address = $('#addAddress').val();
  $.ajax({
    url: "/student",
    type: "post",
    dataType: "json",
    data: {
      sname: sname,
      score: score,
      address: address
    },
    success: function(data) {
      $('#addStudent').modal('hide')
      analyseTranslation(data);
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      alert(XMLHttpRequest.status);
      alert(XMLHttpRequest.readyState);
      alert(textStatus);
    },
  });
}

function modStudentInit(id) {
  $.ajax({
    url: "/student/" + id,
    type: "get",
    dataType: "json",
    success: function(data) {
      $('#modSid').val(data.sid);
      $('#modSname').val(data.sname);
      $('#modScore').val(data.score);
      $('#modAddress').val(data.address);
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      alert(XMLHttpRequest.status);
      alert(XMLHttpRequest.readyState);
      alert(textStatus);
    },
  });
}

function modStudent() {
  var sid = $('#modSid').val();
  var sname = $('#modSname').val();
  var score = $('#modScore').val();
  var address = $('#modAddress').val();
  $.ajax({
    url: "/student/" + sid,
    type: "put",
    dataType: "json",
    data: {
      sname: sname,
      score: score,
      address: address
    },
    success: function(data) {
      $('#modStudent').modal('hide')
      analyseTranslation(data);
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      alert(XMLHttpRequest.status);
      alert(XMLHttpRequest.readyState);
      alert(textStatus);
    },
  });
}

function delStudentInit(id) {
  $("#delStudentButton").attr("onclick","delStudent('" + id + "')");
}

function delStudent(id) {
  $.ajax({
    url: "/student/" + id,
    type: "delete",
    dataType: "json",
    success: function(data) {
      $('#delStudent').modal('hide')
      analyseTranslation(data);
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      alert(XMLHttpRequest.status);
      alert(XMLHttpRequest.readyState);
      alert(textStatus);
    },
  });
}