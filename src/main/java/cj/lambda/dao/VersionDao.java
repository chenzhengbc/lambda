package cj.lambda.dao;

import cj.lambda.entity.Version;

@FunctionalInterface
public interface VersionDao {
    int get(Version version);
}
