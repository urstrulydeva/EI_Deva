package ProjectI.StructuralPattern;

// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee
interface AdvancedMediaPlayer {
    void playMp4(String fileName);
    void playMp3(String fileName);
}

// Concrete Adaptee for MP4
class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }

    @Override
    public void playMp3(String fileName) {
        // Do nothing
    }
}

// Concrete Adaptee for MP3
class Mp3Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }

    @Override
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file. Name: " + fileName);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        } else if (audioType.equalsIgnoreCase("mp3")) {
            advancedMediaPlayer = new Mp3Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("mp3")) {
            advancedMediaPlayer.playMp3(fileName);
        }
    }
}

// Concrete Media Player
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            new Mp3Player().playMp3(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// Main
public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
    }
}

