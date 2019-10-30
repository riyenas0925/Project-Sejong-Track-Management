INSERT INTO tbl_univ(univNo, univTitle) VALUES (1000, "Test Case Univ1");
INSERT INTO tbl_univ(univNo, univTitle) VALUES (1001, "Test Case Univ2");

INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2000, "Test Case Track1", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2001, "Test Case Track2", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2002, "Test Case Track3", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2003, "Test Case Track4", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2004, "Test Case Track5", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2005, "Test Case Track6", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2006, "Test Case Track7", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2007, "Test Case Track8", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2008, "Test Case Track9", 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2009, "Test Case Track10", 2);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2010, "Test Case Track11", 2);

INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3000, "Test Case Subject1");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3001, "Test Case Subject2");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3002, "Test Case Subject3");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3003, "Test Case Subject4");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3004, "Test Case Subject5");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3005, "Test Case Subject6");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3006, "Test Case Subject7");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3007, "Test Case Subject8");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3008, "Test Case Subject9");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3009, "Test Case Subject10");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3010, "Test Case Subject11");
INSERT INTO tbl_subject(subjectCredit, subjectNo, subjectTitle) VALUES (3, 3011, "Test Case Subject12");

INSERT INTO tbl_degree(degreeTitle) VALUES ("degree1");
INSERT INTO tbl_degree(degreeTitle) VALUES ("degree2");
INSERT INTO tbl_degree(degreeTitle) VALUES ("degree3");
INSERT INTO tbl_degree(degreeTitle) VALUES ("degree4");

INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,1);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,2);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,3);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,4);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,5);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,6);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,7);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,8);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,9);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,10);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,2,10);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,3,10);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,4,10);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,1,11);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,2,11);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,3,11);
INSERT INTO tbl_rule(appliedCredit, basicCredit, industryCredit, degreeId, trackId) VALUES (3,6,9,4,11);

INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 1, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 2, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 2, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 3, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 3, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 4, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 4, 4);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 1, 4);

INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 5, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 6, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 6, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 6, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 7, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 8, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 8, 4);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 5, 4);

INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 1, 10);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 2, 10);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (3, 3, 10);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (1, 3, 11);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (2, 2, 11);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES (3, 1, 11);