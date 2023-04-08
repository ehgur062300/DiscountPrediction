var main = {
    init: function() {
        var _this = this;
        $('#btn-search').on('click', function() {
            _this.search();
            return false;
        });
    },
    search: function() {
        var keyword = $('#search').val();
        $.ajax({
            url: '/product/search/' + keyword,
            type: 'GET'
        }).done(function () {
            window.location.href = '/product/search/'+keyword;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
