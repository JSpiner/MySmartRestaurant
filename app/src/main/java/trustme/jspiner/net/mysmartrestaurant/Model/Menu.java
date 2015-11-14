package trustme.jspiner.net.mysmartrestaurant.Model;

import java.util.List;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class Menu {
    public List<SubMenu> items;
    public String menu;

    public Menu(String menu){
        this.menu = menu;
    }
}
