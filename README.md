# AnimatedNavigationView
Animate Navigation View Using SNavigationDrawer to provide great ui.


# Use The Library:
implementation 'com.github.shrikanth7698:Custom-Navigation-Drawer:v0.0.1'

# Implementation
 - In  activity_main.xml
 
 <com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer
 
        android:id="@+id/navigationDrawer"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">
        
        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/container_1"/>
            
             </com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer>
    
 - Add Fragment As Per Your Requierment Like Here We Will Add 3 Fragment And The Go To Java Code Part.
  
  In MainActivity.java
  
  - Import:  "import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;"
  
   "import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;"
  
  - Declare Variables
  
    SNavigationDrawer sNavigationDrawer;
    
    public static Fragment fragment;
  
  - Get Fragments Make Menu Item List And Implement Drawer Listner,i.e:
       
       fragment=new Fragment1();
        
        FragmentManager fragmentManager = getSupportFragmentManager();
        
        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();
        
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        
        List<MenuItem> menuItems = new ArrayList<>();
        
        menuItems.add(new MenuItem("Home",R.drawable.w11));
        menuItems.add(new MenuItem("Second Fragment",R.drawable.w11));
        menuItems.add(new MenuItem("Third Fragment",R.drawable.w11));
        
        sNavigationDrawer.setMenuItemList(Collections.<com.shrikanthravi.customnavigationdrawer2.data.MenuItem>unmodifiableList((List<? extends com.shrikanthravi.customnavigationdrawer2.data.MenuItem>) menuItems));
       
       sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position) {
                    case 0: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragment = new Fragment1();
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();

                        break;
                    }
                    case 1: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragment = new Fragment2();
                        Bundle bundle = new Bundle();



                        fragment.setArguments(bundle);
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();
                        break;
                    }
                    case 2: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragment = new Fragment3();
                        Bundle bundle = new Bundle();


                        fragment.setArguments(bundle);
                        fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container_1, fragment).commit();
                        break;
                    }


                }}
        });
  
 
