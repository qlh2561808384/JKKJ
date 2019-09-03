$(function() {
    function i(e) {
        $("#originalpic img").eq(e).stop(!0, !0).fadeIn(800).siblings("img").hide(),
        $(".thumbpic li").eq(e).addClass("hover").siblings().removeClass("hover"),
        $.browser.msie && $.browser.version == "6.0" && !$.support.style && $("#aPrev,#aNext").css("height", $("#originalpic img").eq(e).height() + "px")
    }
    function s() {
        e >= 0 && e < n - 1 ? (++e, i(e)) : $.dialog({
            title: sdcms_var.n_title,
            icon: "face-sad",
            content: sdcms_var.l_content,
            lock: !0,
            opacity: "0.5",
            okVal: sdcms_var.n_okVal,
            ok: function() {
                e = 0,
                i(0),
                n >= t && (aniPx = (n - t) * 92 + "px", $("#piclist ul").animate({
                    left: "+=" + aniPx
                },
                200)),
                r = 1
            },
            cancelVal: sdcms_var.n_cancelVal,
            cancel: function() {}
        });
        if (r < 0 || r > n - t) return ! 1;
        $("#piclist ul").animate({
            left: "-=92px"
        },
        200),
        r++
    }
    function o() {
        if (e <= 0) return $.message({
            content: sdcms_var.l_content,
            time: 3e3
        }),
        !1;
        e >= 1 && (--e, i(e));
        if (r < 2 || r > n + t) return ! 1;
        $("#piclist ul").animate({
            left: "+=92px"
        },
        200),
        r--
    }
    var e = 0,
    t = 5,
    n = $("#originalpic img").length,
    r = 1;
    $("#originalpic img").eq(0).show(),
    $.browser.msie && $.browser.version == "6.0" && !$.support.style && $("#aPrev,#aNext").css("height", $("#originalpic img").eq(0).height() + "px"),
    $(".thumbpic li").eq(0).addClass("hover"),
    $(".thumbpic tt").each(function(e) {
        var t = e + 1 + "/" + n;
        $(this).html(t)
    }),
    $(".bntnext,#aNext").click(function() {
        s()
    }),
    $(".bntprev,#aPrev").click(function() {
        o()
    }),
    $(".thumbpic li").click(function() {
        e = $(".thumbpic li").index(this),
        i(e)
    })
})