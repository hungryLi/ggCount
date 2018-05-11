package platform.jizhang.biu.service.model;

public class PermisionVO {
    private Integer id;

    private String pName;

    private String pCode;

    private String menuName;

    private Integer menuType;

    private Integer parentMenu;

    private Integer iconType;

    private String iconAddress;

    private String menuHref;
    
    private Integer menuIndex;

    public Integer getMenuIndex() {
		return menuIndex;
	}

	public void setMenuIndex(Integer menuIndex) {
		this.menuIndex = menuIndex;
	}

	private String pDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode == null ? null : pCode.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Integer parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Integer getIconType() {
        return iconType;
    }

    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress == null ? null : iconAddress.trim();
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref == null ? null : menuHref.trim();
    }

    public String getpDesc() {
        return pDesc;
    }

    @Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"pName\":\"" + pName + "\",\"pCode\":\"" + pCode + "\",\"menuName\":\""
				+ menuName + "\",\"menuType\":\"" + menuType + "\",\"parentMenu\":\"" + parentMenu
				+ "\",\"iconType\":\"" + iconType + "\",\"iconAddress\":\"" + iconAddress + "\",\"menuHref\":\""
				+ menuHref + "\",\"menuIndex\":\"" + menuIndex + "\",\"pDesc\":\"" + pDesc + "\"} ";
	}

	public void setpDesc(String pDesc) {
        this.pDesc = pDesc == null ? null : pDesc.trim();
    }
    
}