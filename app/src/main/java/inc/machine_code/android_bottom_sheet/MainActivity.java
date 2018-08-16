package inc.machine_code.android_bottom_sheet;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.view.MenuItemCompat;
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
        Show_Search(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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

    public boolean Show_Search(Menu menu) {
        MenuItem searchViewMenuItem = menu.findItem(R.id.menu_search_bar);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView;
        searchView = (SearchView) MenuItemCompat.getActionView(searchViewMenuItem);
        int searchImgId = android.support.v7.appcompat.R.id.search_button; // I used the explicit layout ID of searchview's ImageView
        ImageView v = (ImageView) searchView.findViewById(searchImgId);
        v.setImageResource(R.drawable.ic_search_icon);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
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
        return true;
    }
}


