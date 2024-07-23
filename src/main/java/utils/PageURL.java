package utils;

public enum PageURL {
	LOGIN("/WEB-INF/view/auth/Login.jsp"),
	USER("/WEB-INF/view/user/User.jsp"),
    DASHBOARD("/WEB-INF/view/admin/dashboard.jsp"),
    REGISTER("/WEB-INF/view/auth/Register.jsp"),
	HOME("/WEB-INF/view/home/home.jsp"),
	PRODUCT_DETAIL("/WEB-INF/view/home/productDetail.jsp"),
	ABOUT_US("/WEB-INF/view/home/AboutUs.jsp"),
	CART("/WEB-INF/view/user/cart.jsp"),
	ORDER("/WEB-INF/view/user/orders.jsp"),
	ADMIN_ORDERS("/WEB-INF/view/admin/Order.jsp");
	

	private final String url;

	private PageURL(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
