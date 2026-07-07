package com.grocery.app.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/grocery/app/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Cart", "GroceryDetails", "Home", "Profile", "Settings", "Lcom/grocery/app/navigation/Screen$Cart;", "Lcom/grocery/app/navigation/Screen$GroceryDetails;", "Lcom/grocery/app/navigation/Screen$Home;", "Lcom/grocery/app/navigation/Screen$Profile;", "Lcom/grocery/app/navigation/Screen$Settings;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/grocery/app/navigation/Screen$Cart;", "Lcom/grocery/app/navigation/Screen;", "()V", "app_debug"})
    public static final class Cart extends com.grocery.app.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.grocery.app.navigation.Screen.Cart INSTANCE = null;
        
        private Cart() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/grocery/app/navigation/Screen$GroceryDetails;", "Lcom/grocery/app/navigation/Screen;", "()V", "app_debug"})
    public static final class GroceryDetails extends com.grocery.app.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.grocery.app.navigation.Screen.GroceryDetails INSTANCE = null;
        
        private GroceryDetails() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/grocery/app/navigation/Screen$Home;", "Lcom/grocery/app/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.grocery.app.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.grocery.app.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/grocery/app/navigation/Screen$Profile;", "Lcom/grocery/app/navigation/Screen;", "()V", "app_debug"})
    public static final class Profile extends com.grocery.app.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.grocery.app.navigation.Screen.Profile INSTANCE = null;
        
        private Profile() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/grocery/app/navigation/Screen$Settings;", "Lcom/grocery/app/navigation/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.grocery.app.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.grocery.app.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
}