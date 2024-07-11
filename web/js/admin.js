function allcheck(checkbox)
{
    var ocheck = document.getElementsByName("check");
    if(checkbox.checked==true){
        for (var i = 0; i < ocheck.length; i++) {
            ocheck[i].checked = true;
        }
    }else{
        for(var i=0;i<ocheck.length;i++){
            ocheck[i].checked=false;
        }
    }
}

function delcheck(){
    // alert("delcheck---delcheck---");
    var allid = new Array();
    var flag = false;
    var ocheck = document.getElementsByName("check");
    for (var i = 0; i < ocheck.length; i++) {
        if (ocheck[i].checked == true) {
            allid.push(ocheck[i].value);
            flag = true;
        }
    }
    alert("delcheck:"+allid);
    if(flag){
        if(confirm("您确定要删除这些记录吗？请谨慎选择！")){
            location.href="delStu?flag=all&id="+allid;
        }

    }else{
        alert("你至少要选择一条记录，才可以进行批量删除操作，请选择要删除的记录..."+allid);
    }

}

function Rdelcheck() {
    var pid = new Array;
    var flag = false;
    var ocheck = document.getElementsByName("check");
    for (var i = 0; i < ocheck.length; i++) {
        if (ocheck[i].checked == true) {
            pid.push(ocheck[i].value);
            flag = true;
        }
    }
    alert("Rdelcheck:" + pid);
    if (flag) {
        if (confirm("您确定要删除这些记录吗？请谨慎操作！")) {
            location.href = "delCom?flag=all&pid=" + pid;
        }
    } else {
        alert("您至少要选择一条记录，才能进行删除操作！");
    }
}
    function Jdelcheck() {
        alert("BBBBBBBBBB");
        var id = new Array;
        var flag = false;
        var ocheck = document.getElementsByName("check");
        for (var i = 0; i < ocheck.length; i++) {
            if (ocheck[i].checked == true) {
                id.push(ocheck[i].value);
                flag = true;
            }
        }
        alert("7777777777:" + id);
        if (flag) {
            if (confirm("您确定要删除这些记录吗？请谨慎操作！")) {
                location.href = "delSpo?flag=all&id=" + id;
            }
        } else {
            alert("您至少要选择一条记录，才能进行删除操作！");
        }
    }

