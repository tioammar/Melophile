package com.vpaliy.data.source.local;

import android.content.ContentResolver;
import android.net.Uri;

public final class MusicContract {

    interface TrackColumns {
        String TRACK_ID="track_id";
        String TRACK_STREAM_URL="track_stream_url";
        String TRACK_ART_URL="track_art_url";
        String TRACK_DURATION="track_duration";
        String TRACK_TAGS="track_tags";
        String TRACK_RELEASE_DATE="track_release_date";
        String TRACK_TITLE="track_title";
        String TRACK_ARTIST="track_artist";
        String TRACK_IS_LIKED="track_is_liked";
        String TRACK_USER_ID="ref_track_user_id";
        String TRACK_PLAYLIST_ID="ref_track_playlist_id";

        String[] COLUMNS={TRACK_ID,TRACK_STREAM_URL,
                TRACK_ART_URL,TRACK_DURATION,TRACK_TAGS,
                TRACK_RELEASE_DATE,TRACK_TITLE,TRACK_ARTIST,
                TRACK_IS_LIKED, TRACK_USER_ID,TRACK_PLAYLIST_ID};
    }

    interface PlaylistColumns {
        String PLAYLIST_ID="playlist_id";
        String PLAYLIST_ART_URL="playlist_art_url";
        String PLAYLIST_DURATION="playlist_duration";
        String PLAYLIST_RELEASE_DATE="playlist_release_date";
        String PLAYLIST_TITLE="playlist_title";
        String PLAYLIST_DESCRIPTION="playlist_description";
        String PLAYLIST_TRACK_COUNT="playlist_track_count";
        String PLAYLIST_GENRES="playlist_genres";
        String PLAYLIST_TAGS="playlist_tags";
        String PLAYLIST_USER_ID="ref_playlist_user_id";

        String[] COLUMNS={ PLAYLIST_ID,PLAYLIST_ART_URL,
                PLAYLIST_DURATION,PLAYLIST_RELEASE_DATE,PLAYLIST_TITLE,
                PLAYLIST_DESCRIPTION,PLAYLIST_TRACK_COUNT,PLAYLIST_GENRES,
                PLAYLIST_TAGS,PLAYLIST_USER_ID};
    }

    interface UserColumns {
        String USER_ID="user_id";
        String USER_ART_URL="user_art_url";
        String USER_NICKNAME="user_nickname";
        String USER_FULLNAME="user_fullname";
        String USER_DESCRIPTION="user_description";
        String USER_FOLLOWINGS_COUNT="user_followings_count";
        String USER_TRACKS_COUNT="user_tracks_count";
        String USER_PLAYLISTS_COUNT="user_playlists_count";
        String USER_FOLLOWER_COUNT="user_follower_count";
        String USER_IS_FOLLOWED="user_is_followed";
        String USER_LIKED_TRACKS_COUNT="user_liked_tracks_count";

        String[] COLUMNS={USER_ID,USER_ART_URL,USER_NICKNAME,
            USER_FULLNAME,USER_NICKNAME,USER_DESCRIPTION,
            USER_FOLLOWINGS_COUNT,USER_TRACKS_COUNT,USER_PLAYLISTS_COUNT,
            USER_FOLLOWER_COUNT,USER_IS_FOLLOWED,USER_LIKED_TRACKS_COUNT};
    }


    public static final String CONTENT_AUTHORITY="com.vpaliy.melophile";

    public static final Uri BASE_CONTENT_URI= Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final String PATH_TRACK="tracks";
    public static final String PATH_PLAYLIST="playlists";
    public static final String PATH_USER="users";

    private MusicContract(){
        throw new IllegalArgumentException();
    }

    public static class Tracks implements TrackColumns{

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_TRACK).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TRACK;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" +PATH_TRACK;

        public static Uri buildTrackUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static Uri buildTrackUserUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).appendPath(PATH_USER).build();
        }

        public String getTrackId(Uri uri){
            return uri.getPathSegments().get(0);
        }
    }

    public static class Playlists implements PlaylistColumns{

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_PLAYLIST).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLAYLIST;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" +PATH_PLAYLIST;

        public static Uri buildPlaylistUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static Uri buildPlaylistTracksUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).appendPath(PATH_PLAYLIST).build();
        }

        public static Uri buildPlaylistUserUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).appendPath(PATH_USER).build();
        }

        public String getPlaylistId(Uri uri){
            return uri.getPathSegments().get(0);
        }
    }
}
