export default $stateProvider => {
    "ngInject";
    $stateProvider.state("overview", {
        abstract: true,
        url: "",
        template: "<ui-view/>"
    });
};
