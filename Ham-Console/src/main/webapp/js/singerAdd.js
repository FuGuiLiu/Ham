$(function () {
    $("#addSinger").click(function () {
        window.location.href = "/console/singer/addSinger.go";
    });
    //更新
    $("#updateSonger").click(function () {
        let SRNAME = $("#srname").val();
        let SRID = $("#ipt_SRID").val();
        let TID = $("#tid").val();
        let INTRO = $("#description").val();
        let AREA = $("#area").val();
        let PIC = $("#pic").val();
        let IS_HOT = $("#isHot").val();
        $.post("/console/singer/update.go", {
            SRNAME: SRNAME,
            SRID: SRID,
            TID: TID,
            INTRO: INTRO,
            AREA: AREA,
            PIC: PIC,
            IS_HOT: IS_HOT
        }, "text", function (data) {
            if (data == "success") {
                alert("更新成功");
            }
        })
    });
});