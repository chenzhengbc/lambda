package cj.lambda.dao;


import cj.lambda.entity.Version;;

import java.util.function.BiFunction;

class VersionDaoTest {
    public static void main(String[] args) {

        VersionDao versionDao = new VersionDao() {
            @Override
            public int get(Version version) {
                return 0;
            }
        };
        System.out.println("Version Dao get returns " + versionDao.get( new Version()));

        VersionDao vd2 = (Version version) -> {return 2;};
        System.out.println("vd2.get() returns " + vd2.get(new Version()));

        VersionDao vd3 = (Version version) -> 3;
        System.out.println("vd3 get() returns " + vd3.get(new Version()));


        BiFunction<String, String, Integer> getLength = (s1, s2) -> s1.length() + s2.length();
        System.out.println("Total Length is " + getLength.apply("4444", "55555"));

    }



}