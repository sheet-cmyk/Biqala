package com.grocery.app.data.local.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.grocery.app.data.local.dao.BannerDao;
import com.grocery.app.data.local.dao.BannerDao_Impl;
import com.grocery.app.data.local.dao.CategoryDao;
import com.grocery.app.data.local.dao.CategoryDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class GroceryDatabase_Impl extends GroceryDatabase {
  private volatile CategoryDao _categoryDao;

  private volatile BannerDao _bannerDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `categories` (`id` TEXT NOT NULL, `nameAr` TEXT NOT NULL, `nameEn` TEXT NOT NULL, `subtitleAr` TEXT NOT NULL, `subtitleEn` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `backgroundColor` INTEGER NOT NULL, `emoji` TEXT NOT NULL DEFAULT '', `itemCount` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `banners` (`id` TEXT NOT NULL, `titleAr` TEXT NOT NULL, `titleEn` TEXT NOT NULL, `subtitleAr` TEXT NOT NULL, `subtitleEn` TEXT NOT NULL, `buttonTextAr` TEXT NOT NULL, `buttonTextEn` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `actionRoute` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1f5607a687ce7cd7431ba352141e8c34')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `categories`");
        db.execSQL("DROP TABLE IF EXISTS `banners`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCategories = new HashMap<String, TableInfo.Column>(10);
        _columnsCategories.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("nameAr", new TableInfo.Column("nameAr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("nameEn", new TableInfo.Column("nameEn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("subtitleAr", new TableInfo.Column("subtitleAr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("subtitleEn", new TableInfo.Column("subtitleEn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("backgroundColor", new TableInfo.Column("backgroundColor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("emoji", new TableInfo.Column("emoji", "TEXT", true, 0, "''", TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("itemCount", new TableInfo.Column("itemCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategories = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategories = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategories = new TableInfo("categories", _columnsCategories, _foreignKeysCategories, _indicesCategories);
        final TableInfo _existingCategories = TableInfo.read(db, "categories");
        if (!_infoCategories.equals(_existingCategories)) {
          return new RoomOpenHelper.ValidationResult(false, "categories(com.grocery.app.data.local.entity.CategoryEntity).\n"
                  + " Expected:\n" + _infoCategories + "\n"
                  + " Found:\n" + _existingCategories);
        }
        final HashMap<String, TableInfo.Column> _columnsBanners = new HashMap<String, TableInfo.Column>(10);
        _columnsBanners.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("titleAr", new TableInfo.Column("titleAr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("titleEn", new TableInfo.Column("titleEn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("subtitleAr", new TableInfo.Column("subtitleAr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("subtitleEn", new TableInfo.Column("subtitleEn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("buttonTextAr", new TableInfo.Column("buttonTextAr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("buttonTextEn", new TableInfo.Column("buttonTextEn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("actionRoute", new TableInfo.Column("actionRoute", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBanners.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBanners = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBanners = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBanners = new TableInfo("banners", _columnsBanners, _foreignKeysBanners, _indicesBanners);
        final TableInfo _existingBanners = TableInfo.read(db, "banners");
        if (!_infoBanners.equals(_existingBanners)) {
          return new RoomOpenHelper.ValidationResult(false, "banners(com.grocery.app.data.local.entity.BannerEntity).\n"
                  + " Expected:\n" + _infoBanners + "\n"
                  + " Found:\n" + _existingBanners);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "1f5607a687ce7cd7431ba352141e8c34", "f7584b340d7e5baef509e0198db2e8b5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "categories","banners");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `categories`");
      _db.execSQL("DELETE FROM `banners`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CategoryDao.class, CategoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BannerDao.class, BannerDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CategoryDao categoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }

  @Override
  public BannerDao bannerDao() {
    if (_bannerDao != null) {
      return _bannerDao;
    } else {
      synchronized(this) {
        if(_bannerDao == null) {
          _bannerDao = new BannerDao_Impl(this);
        }
        return _bannerDao;
      }
    }
  }
}
