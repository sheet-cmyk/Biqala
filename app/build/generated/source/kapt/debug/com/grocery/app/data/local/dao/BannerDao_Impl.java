package com.grocery.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.grocery.app.data.local.entity.BannerEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BannerDao_Impl implements BannerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BannerEntity> __insertionAdapterOfBannerEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public BannerDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBannerEntity = new EntityInsertionAdapter<BannerEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `banners` (`id`,`titleAr`,`titleEn`,`subtitleAr`,`subtitleEn`,`buttonTextAr`,`buttonTextEn`,`imageUrl`,`actionRoute`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BannerEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitleAr() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitleAr());
        }
        if (entity.getTitleEn() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTitleEn());
        }
        if (entity.getSubtitleAr() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSubtitleAr());
        }
        if (entity.getSubtitleEn() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSubtitleEn());
        }
        if (entity.getButtonTextAr() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getButtonTextAr());
        }
        if (entity.getButtonTextEn() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getButtonTextEn());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getImageUrl());
        }
        if (entity.getActionRoute() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getActionRoute());
        }
        statement.bindLong(10, entity.getUpdatedAt());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM banners";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<BannerEntity> banners, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBannerEntity.insert(banners);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> arg0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, arg0);
  }

  @Override
  public Flow<List<BannerEntity>> getAll() {
    final String _sql = "SELECT * FROM banners ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"banners"}, new Callable<List<BannerEntity>>() {
      @Override
      @NonNull
      public List<BannerEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitleAr = CursorUtil.getColumnIndexOrThrow(_cursor, "titleAr");
          final int _cursorIndexOfTitleEn = CursorUtil.getColumnIndexOrThrow(_cursor, "titleEn");
          final int _cursorIndexOfSubtitleAr = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitleAr");
          final int _cursorIndexOfSubtitleEn = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitleEn");
          final int _cursorIndexOfButtonTextAr = CursorUtil.getColumnIndexOrThrow(_cursor, "buttonTextAr");
          final int _cursorIndexOfButtonTextEn = CursorUtil.getColumnIndexOrThrow(_cursor, "buttonTextEn");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfActionRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "actionRoute");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<BannerEntity> _result = new ArrayList<BannerEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BannerEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitleAr;
            if (_cursor.isNull(_cursorIndexOfTitleAr)) {
              _tmpTitleAr = null;
            } else {
              _tmpTitleAr = _cursor.getString(_cursorIndexOfTitleAr);
            }
            final String _tmpTitleEn;
            if (_cursor.isNull(_cursorIndexOfTitleEn)) {
              _tmpTitleEn = null;
            } else {
              _tmpTitleEn = _cursor.getString(_cursorIndexOfTitleEn);
            }
            final String _tmpSubtitleAr;
            if (_cursor.isNull(_cursorIndexOfSubtitleAr)) {
              _tmpSubtitleAr = null;
            } else {
              _tmpSubtitleAr = _cursor.getString(_cursorIndexOfSubtitleAr);
            }
            final String _tmpSubtitleEn;
            if (_cursor.isNull(_cursorIndexOfSubtitleEn)) {
              _tmpSubtitleEn = null;
            } else {
              _tmpSubtitleEn = _cursor.getString(_cursorIndexOfSubtitleEn);
            }
            final String _tmpButtonTextAr;
            if (_cursor.isNull(_cursorIndexOfButtonTextAr)) {
              _tmpButtonTextAr = null;
            } else {
              _tmpButtonTextAr = _cursor.getString(_cursorIndexOfButtonTextAr);
            }
            final String _tmpButtonTextEn;
            if (_cursor.isNull(_cursorIndexOfButtonTextEn)) {
              _tmpButtonTextEn = null;
            } else {
              _tmpButtonTextEn = _cursor.getString(_cursorIndexOfButtonTextEn);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpActionRoute;
            if (_cursor.isNull(_cursorIndexOfActionRoute)) {
              _tmpActionRoute = null;
            } else {
              _tmpActionRoute = _cursor.getString(_cursorIndexOfActionRoute);
            }
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new BannerEntity(_tmpId,_tmpTitleAr,_tmpTitleEn,_tmpSubtitleAr,_tmpSubtitleEn,_tmpButtonTextAr,_tmpButtonTextEn,_tmpImageUrl,_tmpActionRoute,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
