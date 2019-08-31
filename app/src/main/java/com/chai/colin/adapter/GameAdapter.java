package com.chai.colin.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.chai.colin.R;
import com.chai.colin.entity.GameList;

import java.util.List;


public class GameAdapter extends RecyclerView.Adapter {

    private List<GameList> gameLists;
    private LayoutInflater inflater;
    private Context mContext;

    public GameAdapter(Context paramContext, List<GameList> paramList) {
        this.mContext = paramContext;
        this.gameLists = paramList;
        this.inflater = LayoutInflater.from(paramContext);
    }

    private Bitmap createBitmapThumbnail(Bitmap paramBitmap) {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        float f2 = this.mContext.getResources().getDimension(R.dimen.dp_106);
        float f1 = this.mContext.getResources().getDimension(R.dimen.dp_95);
        f2 /= i;
        f1 /= j;
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f2, f1);
        return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }

//    private void setImages(ImageView paramImageView, String paramString1, String paramString2, int viewType)
//    {
//        if ("0".equals(paramString2))
//            paramString1 = Glide.with(this.mContext).load(paramString1).dontAnimate().skipMemoryCache(false).placeholder(viewType).diskCacheStrategy(DiskCacheStrategy.DATA);
//        else
//            paramString1 = Glide.with(this.mContext).load(paramString1).dontAnimate().skipMemoryCache(false).placeholder(viewType).diskCacheStrategy(DiskCacheStrategy.DATA).bitmapTransform(new Transformation[] { new GrayscaleTransformation(this.mContext) });
//        paramString1.into(paramImageView);
//    }

    private Bitmap toGrayscale(Bitmap paramBitmap) {
        int i = paramBitmap.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        ColorMatrix localColorMatrix = new ColorMatrix();
        localColorMatrix.setSaturation(0.0F);
        localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        return localBitmap;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Integer.parseInt("3"))
            return new LiveVideoViewHolder(this.inflater.inflate(R.layout.item_girl, parent, false));
        if (viewType == Integer.parseInt("5"))
            return new ChessCardViewHolder(this.inflater.inflate(R.layout.item_qipai, parent, false));
        if (viewType == Integer.parseInt("4"))
            return new ElectronViewHolder(this.inflater.inflate(R.layout.item_dianzi, parent, false));
        if (viewType == Integer.parseInt("2"))
            return new SportViewHolder(this.inflater.inflate(R.layout.item_sport, parent, false));
        return new CatchFishViewHolder(this.inflater.inflate(R.layout.item_game_common, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object localObject1 = (GameList) this.gameLists.get(position);
        if (holder instanceof LiveVideoViewHolder) {
//            if (TextUtils.isEmpty(((GameList)localObject1).getIcon2()))
//                paramViewHolder = ((GameList)localObject1).getConUrl();
//            else
//                paramViewHolder = ((GameList)localObject1).getIcon2();
//            localObject1 = ((GameList)localObject1).getIsFix();
            if (position == 0) {
                int width = (int) this.mContext.getResources().getDimension(R.dimen.dp_160);
                this.mContext.getResources().getDimension(R.dimen.dp_225);
                ViewGroup.LayoutParams localLayoutParams = ((LiveVideoViewHolder) holder).imageView.getLayoutParams();
                localLayoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                localLayoutParams.width = width;
                ((LiveVideoViewHolder) holder).imageView.setLayoutParams(localLayoutParams);
//                setImages(((LiveVideoViewHolder) holder).imageView, paramViewHolder, (String)localObject1, R.drawable.placeholder);
                return;
            } else {
                this.mContext.getResources().getDimension(R.dimen.dp_225);
                this.mContext.getResources().getDimension(R.dimen.dp_107);
//                setImages(((LiveVideoViewHolder) holder).imageView, paramViewHolder, (String)localObject1, R.drawable.placeholder2);
                // todo 将imageview改造成圆的
                return;
            }
        }

        if (holder instanceof CatchFishViewHolder) {
            CatchFishViewHolder localObject2 = (CatchFishViewHolder) holder;
//            if (((GameList) localObject1).getIcon2() == null)
//                paramViewHolder = ((GameList) localObject1).getConUrl();
//            else
//                paramViewHolder = ((GameList) localObject1).getIcon2();
//            localObject1 = ((GameList) localObject1).getIsFix();

            if ("0".equals(localObject1)) {
                Glide.with(mContext).asBitmap().dontAnimate().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(R.drawable.placeholder).into(new ImageViewTarget<Bitmap>(localObject2.imageView) {
                    @Override
                    protected void setResource(@Nullable Bitmap resource) {
                        localObject2.imageView.setImageBitmap(createBitmapThumbnail(resource));
                    }
                });
            } else {
                Glide.with(mContext).asBitmap().dontAnimate().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(R.drawable.placeholder).into(new ImageViewTarget<Bitmap>(localObject2.imageView) {
                    @Override
                    protected void setResource(@Nullable Bitmap resource) {
                        localObject2.imageView.setImageBitmap(toGrayscale(createBitmapThumbnail(resource)));
                    }
                });
            }
            return;
        }

//        if (holder instanceof ChessCardViewHolder) {
//            ChessCardViewHolder  localObject2 = (ChessCardViewHolder) holder;
//            if (TextUtils.isEmpty(((GameList) localObject1).getIcon2()))
//                paramViewHolder = ((GameList) localObject1).getConUrl();
//            else
//                paramViewHolder = ((GameList) localObject1).getIcon2();
//            localObject1 = ((GameList) localObject1).getIsFix();
//            this.mContext.getResources().getDimension(R.dimen.dp_163);
//            this.mContext.getResources().getDimension(R.dimen.dp_220);
//            setImages(((ElectronViewHolder) localObject2).a, paramViewHolder, (String) localObject1, R.drawable.placeholder);
//        }
//
//        if (holder instanceof ElectronViewHolder) {
//            localObject2 = (ElectronViewHolder) paramViewHolder;
//            if (TextUtils.isEmpty(((GameList) localObject1).getIcon2()))
//                paramViewHolder = ((GameList) localObject1).getConUrl();
//            else
//                paramViewHolder = ((GameList) localObject1).getIcon2();
//            localObject1 = ((GameList) localObject1).getIsFix();
//            this.mContext.getResources().getDimension(R.dimen.dp_219);
//            this.mContext.getResources().getDimension(R.dimen.dp_103);
//            setImages(((ElectronViewHolder) localObject2).a, paramViewHolder, (String) localObject1, R.drawable.placeholder2);
//            return;
//        }
//        if (holder instanceof SportViewHolder){
//            localObject2 = (SportViewHolder) paramViewHolder;
//            if (TextUtils.isEmpty(((GameList) localObject1).getIcon2()))
//                paramViewHolder = ((GameList) localObject1).getConUrl();
//            else
//                paramViewHolder = ((GameList) localObject1).getIcon2();
//            localObject1 = ((GameList) localObject1).getIsFix();
//            this.mContext.getResources().getDimension(R.dimen.dp_402);
//            this.mContext.getResources().getDimension(R.dimen.dp_217);
//            setImages(((ElectronViewHolder) localObject2).a, paramViewHolder, (String) localObject1, R.drawable.placeholder);
//        }

    }

    @Override
    public int getItemCount() {
        List localList = this.gameLists;
        if (localList == null)
            return 0;
        return localList.size();
    }

    @Override
    public int getItemViewType(int position) {
        String str = gameLists.get(position).getGameKind();
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException localNumberFormatException) {
            localNumberFormatException.printStackTrace();
        }
        return 0;
    }

    public static class LiveVideoViewHolder extends RecyclerView.ViewHolder {
        //真人视讯
        public ImageView imageView;

        public LiveVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_head);
        }
    }

    public static class ChessCardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ChessCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_head);
        }
    }

    public static class ElectronViewHolder extends RecyclerView.ViewHolder {
        //电子游艺
        public ImageView imageView;

        public ElectronViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_head);
        }
    }

    public static class SportViewHolder extends RecyclerView.ViewHolder {
        //        体育赛事
        public ImageView imageView;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_head);
        }
    }

    public static class CatchFishViewHolder extends RecyclerView.ViewHolder {
        //捕鱼
        public ImageView imageView;

        public CatchFishViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_head);
        }
    }


}
