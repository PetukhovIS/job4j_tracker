package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0.0D;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalSubjects == 0 ? 0 : totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            int numberOfSubjects = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double averageScore = numberOfSubjects == 0 ? 0 : totalScore / numberOfSubjects;
            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>();
        Map<String, Integer> subjectCounts = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();
                subjectScores.put(subjectName, subjectScores.getOrDefault(subjectName, 0) + score);
                subjectCounts.put(subjectName, subjectCounts.getOrDefault(subjectName, 0) + 1);
            }
        }
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            int count = subjectCounts.get(subjectName);
            double averageScore = (double) totalScore / count;
            result.add(new Label(subjectName, averageScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            if (best == null || totalScore > best.score()) {
                best = new Label(pupil.name(), totalScore);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(), subjectScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        Label best = null;
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            if (best == null || entry.getValue() > best.score()) {
                best = new Label(entry.getKey(), entry.getValue());
            }
        }
        return best;
    }
}
