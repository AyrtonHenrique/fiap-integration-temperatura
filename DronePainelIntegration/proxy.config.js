const proxy = [
	{
		context: "/uri",
		target: "http://localhost:8080/drone-app",
		pathRewrite: { "^/uri": "" },
	},
	{
		context: "/med",
		target: "http://localhost:8082/api/v1",
		pathRewrite: { "^/med": "" },
	}
];
module.exports = proxy;
