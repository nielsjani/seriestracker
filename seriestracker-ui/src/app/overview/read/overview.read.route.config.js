export default $stateProvider => {
    "ngInject";
    $stateProvider.state("overview.read", {
        url: "/overview",
        template: "<overview-read "
        + "></overview-read>"
    });
};


