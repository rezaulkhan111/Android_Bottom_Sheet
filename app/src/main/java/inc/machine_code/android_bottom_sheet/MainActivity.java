package inc.machine_code.android_bottom_sheet;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //   LinearLayout llBottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    //  Button b;

    BottomSheetDialog bottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_and_search_menu, menu);
        super.onCreateOptionsMenu(menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search_bar:
                Menu menu2 = new Menu() {
                    @Override
                    public MenuItem add(CharSequence title) {
                        return null;
                    }

                    @Override
                    public MenuItem add(int titleRes) {
                        return null;
                    }

                    @Override
                    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
                        return null;
                    }

                    @Override
                    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
                        return null;
                    }

                    @Override
                    public SubMenu addSubMenu(CharSequence title) {
                        return null;
                    }

                    @Override
                    public SubMenu addSubMenu(int titleRes) {
                        return null;
                    }

                    @Override
                    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
                        return null;
                    }

                    @Override
                    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
                        return null;
                    }

                    @Override
                    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
                        return 0;
                    }

                    @Override
                    public void removeItem(int id) {

                    }

                    @Override
                    public void removeGroup(int groupId) {

                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {

                    }

                    @Override
                    public void setGroupVisible(int group, boolean visible) {

                    }

                    @Override
                    public void setGroupEnabled(int group, boolean enabled) {

                    }

                    @Override
                    public boolean hasVisibleItems() {
                        return false;
                    }

                    @Override
                    public MenuItem findItem(int id) {
                        return null;
                    }

                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public MenuItem getItem(int index) {
                        return null;
                    }

                    @Override
                    public void close() {

                    }

                    @Override
                    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
                        return false;
                    }

                    @Override
                    public boolean isShortcutKey(int keyCode, KeyEvent event) {
                        return false;
                    }

                    @Override
                    public boolean performIdentifierAction(int id, int flags) {
                        return false;
                    }

                    @Override
                    public void setQwertyMode(boolean isQwerty) {

                    }
                };
                Show_Search(menu2);
                return true;
            case R.id.setting:
                showBottomSheetDialog();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void showBottomSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        ImageView imageView1, imageView2, imageView3;
        TextView textView;
        String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaan\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmm\n" +
                "mmmmmmmmmmmmmmmmmmmmmm";

        textView = view.findViewById(R.id.tv_more_info);
        imageView1 = view.findViewById(R.id.iv_facebook);
        imageView2 = view.findViewById(R.id.iv_twitter);
        imageView3 = view.findViewById(R.id.iv_mail);

        imageView1.setImageResource(R.mipmap.facebook_round);
        imageView2.setImageResource(R.mipmap.ic_twitter);
        imageView3.setImageResource(R.mipmap.ic_mail);


        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setVerticalScrollBarEnabled(true);
        textView.setText(text);

        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();

        imageView1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    public void Show_Search(Menu menu) {

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView;
        searchView = (SearchView) menu.findItem(R.id.menu_search_bar).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String get_customer_text) {

                return false;
            }
        });
    }
}


