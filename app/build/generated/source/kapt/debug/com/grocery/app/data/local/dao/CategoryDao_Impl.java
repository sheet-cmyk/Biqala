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
import com.grocery.app.data.local.entity.CategoryEntity;
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
public final class CategoryDao_Impl implements CategoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CategoryEntity> __insertionAdapterOfCategoryEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CategoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategoryEntity = new EntityInsertionAdapter<CategoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `categories` (`id`,`nameAr`,`nameEn`,`subtitleAr`,`subtitleEn`,`imageUrl`,`backgroundColor`,`emoji`,`itemCount`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CategoryEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getNameAr() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNameAr());
        }
        if (entity.getNameEn() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNameEn());
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
        if (entity.getImageUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getImageUrl());
        }
        statement.bindLong(7, entity.getBackgroundColor());
        if (entity.getEmoji() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getEmoji());
        }
        statement.bindLong(9, entity.getItemCount());
        statement.bindLong(10, entity.getUpdatedAt());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM categories";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<CategoryEntity> categories,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCategoryEntity.insert(categories);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
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
    }, $completion);
  }

  @Override
  public Flow<List<CategoryEntity>> getAll() {
    final String _sql = "SELECT * FROM categories ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"categories"}, new Callable<List<CategoryEntity>>() {
      @Override
      @NonNull
      public List<CategoryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNameAr = CursorUtil.getColumnIndexOrThrow(_cursor, "nameAr");
          final int _cursorIndexOfNameEn = CursorUtil.getColumnIndexOrThrow(_cursor, "nameEn");
          final int _cursorIndexOfSubtitleAr = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitleAr");
          final int _cursorIndexOfSubtitleEn = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitleEn");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfBackgroundColor = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundColor");
          final int _cursorIndexOfEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "emoji");
          final int _cursorIndexOfItemCount = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCount");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<CategoryEntity> _result = new ArrayList<CategoryEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CategoryEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpNameAr;
            if (_cursor.isNull(_cursorIndexOfNameAr)) {
              _tmpNameAr = null;
            } else {
              _tmpNameAr = _cursor.getString(_cursorIndexOfNameAr);
            }
            final String _tmpNameEn;
            if (_cursor.isNull(_cursorIndexOfNameEn)) {
              _tmpNameEn = null;
            } else {
              _tmpNameEn = _cursor.getString(_cursorIndexOfNameEn);
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
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final long _tmpBackgroundColor;
            _tmpBackgroundColor = _cursor.getLong(_cursorIndexOfBackgroundColor);
            final String _tmpEmoji;
            if (_cursor.isNull(_cursorIndexOfEmoji)) {
              _tmpEmoji = null;
            } else {
              _tmpEmoji = _cursor.getString(_cursorIndexOfEmoji);
            }
            final int _tmpItemCount;
            _tmpItemCount = _cursor.getInt(_cursorIndexOfItemCount);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new CategoryEntity(_tmpId,_tmpNameAr,_tmpNameEn,_tmpSubtitleAr,_tmpSubtitleEn,_tmpImageUrl,_tmpBackgroundColor,_tmpEmoji,_tmpItemCount,_tmpUpdatedAt);
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
