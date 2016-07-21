package com.brioal.uu.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioGroup;

import com.brioal.brioallib.base.BaseFragment;
import com.brioal.brioallib.interfaces.OnLoadCompleteListener;
import com.brioal.brioallib.util.ToastUtils;
import com.brioal.uu.LineRadioButton;
import com.brioal.uu.R;
import com.brioal.uu.adapter.GuangGridAdapter;
import com.brioal.uu.entity.GuangEntity;
import com.brioal.uu.util.DataLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brioal on 2016/7/19.
 */

public class GuangFragment extends BaseFragment {
    static {
        TAG = "GuangFragment";
    }

    private static GuangFragment mFragment;
    @Bind(R.id.fra_guang_et_search)
    EditText mEtSearch;
    @Bind(R.id.fra_guang_rb_nanshi)
    LineRadioButton mRbNanshi;
    @Bind(R.id.fra_guang_rb_nvxie)
    LineRadioButton mRbNvxie;
    @Bind(R.id.fra_guang_rb_xiangbao)
    LineRadioButton mRbXiangbao;
    @Bind(R.id.fra_guang_rb_jiadian)
    LineRadioButton mRbJiadian;
    @Bind(R.id.fra_guang_rb_peishi)
    LineRadioButton mRbPeishi;
    @Bind(R.id.fra_guang_rb_muyin)
    LineRadioButton mRbMuyin;
    @Bind(R.id.fra_guang_rb_meizhuang)
    LineRadioButton mRbMeizhuang;
    @Bind(R.id.fra_guang_rb_jiaju)
    LineRadioButton mRbJiaju;
    @Bind(R.id.fra_guang_rb_meishi)
    LineRadioButton mRbMeishi;
    @Bind(R.id.fra_guang_gridview)
    GridView mGridview;
    @Bind(R.id.fra_guang_rb_nvzhuang)
    LineRadioButton mRbNvzhuang;
    @Bind(R.id.fra_guang_rg_group)
    RadioGroup mRgGroup;

    private GuangGridAdapter mAdapter;
    private String mIndex = "男士";
    private List<GuangEntity> mList;


    public static final GuangFragment newInstance() {
        if (mFragment == null) {
            mFragment = new GuangFragment();
        }

        return mFragment;
    }


    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();
        mRootView = inflater.inflate(R.layout.fra_guang, container, false);
        ButterKnife.bind(this, mRootView);
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = mList.get(position).getTitle();
                ToastUtils.showToast(mContext, title);
            }
        });
        mRgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.fra_guang_rb_nanshi: //男士
                        mIndex = "男士";
                        break;
                    case R.id.fra_guang_rb_nvxie: //女鞋
                        mIndex = "女鞋";
                        break;
                    case R.id.fra_guang_rb_nvzhuang: //女装
                        mIndex = "女装";
                        break;
                    case R.id.fra_guang_rb_xiangbao: //箱包
                        mIndex = "箱包";
                        break;
                    case R.id.fra_guang_rb_jiadian: //家电
                        mIndex = "家电";
                        break;
                    case R.id.fra_guang_rb_peishi: //配饰
                        mIndex = "配饰";
                        break;
                    case R.id.fra_guang_rb_muyin: //母婴
                        mIndex = "母婴";
                        break;
                    case R.id.fra_guang_rb_meizhuang: //美妆
                        mIndex = "美妆";
                        break;
                    case R.id.fra_guang_rb_jiaju: //家居
                        mIndex = "家居";
                        break;
                    case R.id.fra_guang_rb_meishi: //美食
                        mIndex = "美食";
                        break;

                }
                ToastUtils.showToast(mContext,mIndex);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadDataNet();
                    }
                }).start();
            }
        });
    }

    @Override
    public void loadDataNet() {
        super.loadDataNet();
        DataLoader.newInstance(mContext).getGuangEnties(mIndex, new OnLoadCompleteListener() {
            @Override
            public void onSuccess(List list) {
                mList = list;
                mHandler.sendEmptyMessage(TYPE_INIT_VIEW);
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    @Override
    public void setView() {
        super.setView();
        mAdapter = new GuangGridAdapter(mContext, mList);
        mGridview.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
