$(function () {
    var isBtnFocus = false;

    $(document).off('click.bs.dropdown.data-api');
    $("#btn_input").focus(function () {
        isBtnFocus = true;
        if ($("#btn_input").val() == "" || $("#btn_input").val() == null) {
            $("#div_searchDropDown").html("<a class='dropdown-item' href=\"/portal/song/songsLists.go?AID=7\" style='text-decoration: none'><em style='margin-right: 15%;font: normal bold 16px 微软雅黑;color: red;'>1</em>刻骨铭心</a>\n" +
                "<a class='dropdown-item' href=\"/portal/song/songsLists.go?AID=2\" style='text-decoration: none'><em style='margin-right: 15%;font: normal bold 16px 微软雅黑;color: red;'>2</em>做你的男人</a>\n" +
                "<a class='dropdown-item' href=\"/portal/song/songsLists.go?AID=1\" style='text-decoration: none'><em style='margin-right: 15%;font: normal bold 16px 微软雅黑;color: red;'>3</em>一颗滚石的25年</a>");
        }
        $("#div_searchDropDown").show();

        let btnVal = $("#btn_input").val().trim();
        if (btnVal.trim() != null && btnVal !== "") {
            $.ajax({
                "url": "/portal/album/search.go",
                "type": "GET",
                "data": "albumName=" + btnVal.trim(),
                "dataType": "JSON",
                "success": success
            });

            function success(data) {
                if (data == "") {
                    $("#div_searchDropDown").hide();
                }
                var json = JSON.parse(data);

                $("#div_searchDropDown").html("");
                for (let i = 0; i < json.length; i++) {
                    $("#div_searchDropDown").append("<a class='dropdown-item' href='/portal/song/songsLists.go?AID=" + json[i].aID + "'>" + json[i].aNAME + "</a>");
                }
                $("#div_searchDropDown").show();

                $("#div_searchDropDown").addClass("href")
            }
        }

        $("#btn_input").bind('input propertychange', function () {
            let btnVal = $("#btn_input").val().trim();
            if (btnVal.trim() != null && btnVal !== "") {
                $.ajax({
                    "url": "/portal/album/search.go",
                    "type": "GET",
                    "data": "albumName=" + btnVal.trim(),
                    "dataType": "JSON",
                    "success": success
                });

                function success(data) {
                    if (data == "") {
                        $("#div_searchDropDown").hide();
                    }
                    var json = JSON.parse(data);

                    $("#div_searchDropDown").html("");
                    for (let i = 0; i < json.length; i++) {
                        $("#div_searchDropDown").append("<a class='dropdown-item' href='/portal/song/songsLists.go?AID=" + json[i].aID + "'>" + json[i].aNAME + "</a>");
                    }
                    $("#div_searchDropDown").show();

                    $("#div_searchDropDown").addClass("href")
                }
            }

        });
    });
    $("#btn_input").on('input', function () {

        if ($("#btn_input").val().trim() == "" || $("#btn_input").val().length == 0) {
            $("#div_searchDropDown").html("<a class='dropdown-item' href=\"/portal/song/songsLists.go?AID=7\" style='text-decoration: none'><em style='margin-right: 15%;font: normal bold 16px 微软雅黑;color: red;'>1</em>刻骨铭心</a>\n" +
                "<a class='dropdown-item' href=\"/portal/song/songsLists.go?AID=2\" style='text-decoration: none'><em style='margin-right: 15%;font: normal bold 16px 微软雅黑;color: yellow;'>2</em>做你的男人</a>\n" +
                "<a class='dropdown-item' href=\"/portal/song/songsLists.go?AID=1\" style='text-decoration: none'><em style='margin-right: 15%;font: normal bold 16px 微软雅黑;color: blue;'>2</em>一颗滚石的25年</a>");
            $("#div_searchDropDown").show();
        }
    });
    $("#div_searchDropDown").on('mouseleave', function () {
        isBtnFocus = false;
    });
    $(document).click(function () {
        let jQuery = $("#div_searchDropDown").css('display');
        if (jQuery == "block" && isBtnFocus == false) {
            $("#div_searchDropDown").hide();
        }
    })
});