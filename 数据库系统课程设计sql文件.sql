/*
 Navicat Premium Data Transfer

 Source Server         : zjutwwt0
 Source Server Type    : PostgreSQL
 Source Server Version : 90204
 Source Host           : 192.168.232.135:26000
 Source Catalog        : wwt_db_uni
 Source Schema         : wuwt

 Target Server Type    : PostgreSQL
 Target Server Version : 90204
 File Encoding         : 65001

 Date: 14/07/2024 10:41:55
*/


-- ----------------------------
-- Table structure for wuwtadmin_accounts
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtadmin_accounts";
CREATE TABLE "wuwt"."wuwtadmin_accounts" (
  "wuwtadminname" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtadminpassword" char(64) COLLATE "pg_catalog"."default",
  "wuwtadminrole" varchar(20) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for wuwtbasicinfo
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtbasicinfo";
CREATE TABLE "wuwt"."wuwtbasicinfo" (
  "wuwtstudentid" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtname" varchar(50) COLLATE "pg_catalog"."default",
  "wuwtnamepy" varchar(50) COLLATE "pg_catalog"."default",
  "wuwtgender" varchar(10) COLLATE "pg_catalog"."default",
  "wuwtnation" varchar(50) COLLATE "pg_catalog"."default",
  "wuwtbirthdate" timestamp(0),
  "wuwtnativeplace" varchar(100) COLLATE "pg_catalog"."default",
  "wuwtpoliticalstatus" varchar(50) COLLATE "pg_catalog"."default",
  "wuwtidtype" varchar(50) COLLATE "pg_catalog"."default",
  "wuwtidnumber" varchar(50) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for wuwtclass
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtclass";
CREATE TABLE "wuwt"."wuwtclass" (
  "wuwtclassid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtclassname" varchar(20) COLLATE "pg_catalog"."default",
  "wuwtmajorid" char(7) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for wuwtcourses
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtcourses";
CREATE TABLE "wuwt"."wuwtcourses" (
  "wuwtcourseid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtcoursename" varchar(20) COLLATE "pg_catalog"."default",
  "wuwtcoursehours" int4,
  "wuwtcoursecredits" float8,
  "wuwtassessmentmethod" char(9) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for wuwtmajors
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtmajors";
CREATE TABLE "wuwt"."wuwtmajors" (
  "wuwtmajorid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtmajorname" varchar(30) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for wuwtscores
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtscores";
CREATE TABLE "wuwt"."wuwtscores" (
  "wuwtstudentid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtcourseid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtsemester" char(11) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtscore" float8
)
;

-- ----------------------------
-- Table structure for wuwtstudents
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtstudents";
CREATE TABLE "wuwt"."wuwtstudents" (
  "wuwtclassid" char(7) COLLATE "pg_catalog"."default",
  "wuwtstudentid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtstudentname" varchar(20) COLLATE "pg_catalog"."default",
  "wuwthometown" varchar(20) COLLATE "pg_catalog"."default",
  "wuwtgender" char(4) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtage" int4,
  "wuwtearnedcredits" int4
)
;

-- ----------------------------
-- Table structure for wuwtteacher_courses
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtteacher_courses";
CREATE TABLE "wuwt"."wuwtteacher_courses" (
  "wuwtcourseid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtsemester" varchar(11) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtteacherid" char(7) COLLATE "pg_catalog"."default",
  "wuwtclassid" char(7) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for wuwtteachers
-- ----------------------------
DROP TABLE IF EXISTS "wuwt"."wuwtteachers";
CREATE TABLE "wuwt"."wuwtteachers" (
  "wuwtteacherid" char(7) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtteachername" varchar(20) COLLATE "pg_catalog"."default",
  "wuwtteachergender" char(4) COLLATE "pg_catalog"."default" NOT NULL,
  "wuwtteacherage" int4,
  "wuwttitle" varchar(20) COLLATE "pg_catalog"."default",
  "wuwtcontactnumber" char(11) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Function structure for wuwtauto_create_student_account
-- ----------------------------
DROP FUNCTION IF EXISTS "wuwt"."wuwtauto_create_student_account"();
CREATE OR REPLACE FUNCTION "wuwt"."wuwtauto_create_student_account"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
BEGIN
    -- 插入账号信息，密码是SHA256加密的
    INSERT INTO WuwtAdmin_Accounts(WuwtadminName, WuwtadminPassword, WuwtadminRole)
    VALUES (NEW.WuwtstudentID, '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '学生');
    RETURN NEW;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for wuwtauto_create_teacher_account
-- ----------------------------
DROP FUNCTION IF EXISTS "wuwt"."wuwtauto_create_teacher_account"();
CREATE OR REPLACE FUNCTION "wuwt"."wuwtauto_create_teacher_account"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
BEGIN
    -- 插入账号信息，密码是SHA256加密的
    INSERT INTO WuwtAdmin_Accounts(WuwtadminName, WuwtadminPassword, WuwtadminRole)
    VALUES (NEW.WuwtteacherID, '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '教师');
    RETURN NEW;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for wuwtfn_credit
-- ----------------------------
DROP FUNCTION IF EXISTS "wuwt"."wuwtfn_credit"("p_studentid" bpchar, "p_courseid" bpchar, "p_semester" bpchar, "p_score" int4, "p_credits" float8, "p_action" bpchar);
CREATE OR REPLACE FUNCTION "wuwt"."wuwtfn_credit"("p_studentid" bpchar, "p_courseid" bpchar, "p_semester" bpchar, "p_score" int4, "p_credits" float8, "p_action" bpchar)
  RETURNS "pg_catalog"."void" AS $BODY$
BEGIN
    IF p_action = 'UPDATE' THEN
        -- 更新成绩信息
        UPDATE wuwt.wuwtscores
        SET wuwtscore = p_score
        WHERE wuwtstudentid = p_studentid AND wuwtcourseid = p_courseid AND wuwtsemester = p_semester;

        -- 重新计算并更新学生的累计学分
        UPDATE wuwt.wuwtstudents
        SET wuwtearnedcredits = (
            SELECT COALESCE(SUM(C.wuwtcoursecredits * (S.wuwtscore >= 60)::int), 0)
            FROM wuwt.wuwtscores S
            JOIN wuwt.wuwtcourses C ON S.wuwtcourseid = C.wuwtcourseid
            WHERE S.wuwtstudentid = p_studentid
        )
        WHERE wuwtstudentid = p_studentid;
    END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for wuwtfn_delete_student_admin
-- ----------------------------
DROP FUNCTION IF EXISTS "wuwt"."wuwtfn_delete_student_admin"();
CREATE OR REPLACE FUNCTION "wuwt"."wuwtfn_delete_student_admin"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
BEGIN
    DELETE FROM wuwt.wuwtadmin_accounts
    WHERE wuwtadminname = OLD.wuwtstudentid;
    RETURN OLD;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for wuwtfn_delete_teacher_admin
-- ----------------------------
DROP FUNCTION IF EXISTS "wuwt"."wuwtfn_delete_teacher_admin"();
CREATE OR REPLACE FUNCTION "wuwt"."wuwtfn_delete_teacher_admin"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
BEGIN
    DELETE FROM wuwt.wuwtadmin_accounts
    WHERE wuwtadminname = OLD.wuwtteacherid;
    RETURN OLD;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for wuwtfn_rank
-- ----------------------------
DROP FUNCTION IF EXISTS "wuwt"."wuwtfn_rank"("p_semester" bpchar, "p_courseid" bpchar, "p_classid" bpchar);
CREATE OR REPLACE FUNCTION "wuwt"."wuwtfn_rank"("p_semester" bpchar, "p_courseid" bpchar, "p_classid" bpchar)
  RETURNS TABLE("wuwtstudentid" bpchar, "wuwtstudentname" varchar, "wuwtcoursename" varchar, "wuwtscore" float8, "wuwtscorerank" int8) AS $BODY$
BEGIN
    RETURN QUERY 
    SELECT 
        S.wuwtstudentid, 
        S.wuwtstudentname, 
        C.wuwtcoursename, 
        Sc.wuwtscore,
        RANK() OVER (PARTITION BY Sc.wuwtcourseid ORDER BY Sc.wuwtscore DESC) AS wuwtscorerank
    FROM 
        wuwt.wuwtscores Sc
    INNER JOIN 
        wuwt.wuwtstudents S ON Sc.wuwtstudentid = S.wuwtstudentid
    INNER JOIN 
        wuwt.wuwtcourses C ON Sc.wuwtcourseid = C.wuwtcourseid
    WHERE 
        Sc.wuwtcourseid = TRIM(p_courseid)
        AND Sc.wuwtsemester = TRIM(p_semester)
        AND (TRIM(p_classid) = '' OR TRIM(p_classid) IS NULL OR S.wuwtclassid = TRIM(p_classid));
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

-- ----------------------------
-- View structure for wuwtarea
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtarea";
CREATE VIEW "wuwt"."wuwtarea" AS  SELECT wuwtstudents.wuwthometown, count(*) AS area_sum
   FROM wuwt.wuwtstudents
  GROUP BY wuwtstudents.wuwthometown;

-- ----------------------------
-- View structure for wuwtmajorclass
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtmajorclass";
CREATE VIEW "wuwt"."wuwtmajorclass" AS  SELECT m.wuwtmajorid AS majornum, m.wuwtmajorname AS majorname, 
    c.wuwtclassid AS classnum, c.wuwtclassname AS classname
   FROM wuwt.wuwtmajors m
   JOIN wuwt.wuwtclass c ON m.wuwtmajorid = c.wuwtmajorid;

-- ----------------------------
-- View structure for wuwtteachcourse
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtteachcourse";
CREATE VIEW "wuwt"."wuwtteachcourse" AS  SELECT tc.wuwtcourseid, c.wuwtcoursename, t.wuwtteachername, tc.wuwtsemester, 
    c.wuwtcoursecredits AS credit, c.wuwtcoursehours AS coursehours, 
    c.wuwtassessmentmethod AS examform, cl.wuwtclassid, cl.wuwtclassname
   FROM wuwt.wuwtcourses c
   JOIN wuwt.wuwtteacher_courses tc ON c.wuwtcourseid = tc.wuwtcourseid
   JOIN wuwt.wuwtteachers t ON tc.wuwtteacherid = t.wuwtteacherid
   JOIN wuwt.wuwtclass cl ON tc.wuwtclassid = cl.wuwtclassid;

-- ----------------------------
-- View structure for wuwtsemesterscore
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtsemesterscore";
CREATE VIEW "wuwt"."wuwtsemesterscore" AS  SELECT s.wuwtstudentid, s.wuwtstudentname, sc.wuwtcourseid, c.wuwtcoursename, 
    sc.wuwtsemester, sc.wuwtscore
   FROM wuwt.wuwtstudents s
   JOIN wuwt.wuwtscores sc ON s.wuwtstudentid = sc.wuwtstudentid
   JOIN wuwt.wuwtcourses c ON sc.wuwtcourseid = c.wuwtcourseid;

-- ----------------------------
-- View structure for wuwtstudent_course_scores
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtstudent_course_scores";
CREATE VIEW "wuwt"."wuwtstudent_course_scores" AS  SELECT sc.wuwtsemester, sc.wuwtcourseid, c.wuwtcoursename, sc.wuwtstudentid, 
    s.wuwtstudentname, c.wuwtcoursecredits, sc.wuwtscore
   FROM wuwt.wuwtscores sc
   JOIN wuwt.wuwtcourses c ON sc.wuwtcourseid = c.wuwtcourseid
   JOIN wuwt.wuwtstudents s ON sc.wuwtstudentid = s.wuwtstudentid;

-- ----------------------------
-- View structure for wuwtteacher_course_average
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtteacher_course_average";
CREATE VIEW "wuwt"."wuwtteacher_course_average" AS  SELECT tc.wuwtteacherid, c.wuwtcourseid, c.wuwtcoursename, s.wuwtsemester, 
    avg(s.wuwtscore) AS avg
   FROM wuwt.wuwtcourses c
   JOIN wuwt.wuwtteacher_courses tc ON c.wuwtcourseid = tc.wuwtcourseid
   JOIN wuwt.wuwtscores s ON c.wuwtcourseid = s.wuwtcourseid
  GROUP BY tc.wuwtteacherid, c.wuwtcourseid, c.wuwtcoursename, s.wuwtsemester;

-- ----------------------------
-- View structure for wuwtteacher_search_score
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtteacher_search_score";
CREATE VIEW "wuwt"."wuwtteacher_search_score" AS  SELECT s.wuwtstudentid, s.wuwtstudentname, c.wuwtcoursename, c.wuwtcourseid, 
    sc.wuwtsemester, sc.wuwtscore, t.wuwtteacherid
   FROM wuwt.wuwtstudents s
   JOIN wuwt.wuwtscores sc ON s.wuwtstudentid = sc.wuwtstudentid
   JOIN wuwt.wuwtcourses c ON sc.wuwtcourseid = c.wuwtcourseid
   JOIN wuwt.wuwtteacher_courses tc ON tc.wuwtcourseid = c.wuwtcourseid AND tc.wuwtsemester::bpchar = sc.wuwtsemester
   JOIN wuwt.wuwtteachers t ON tc.wuwtteacherid = t.wuwtteacherid;

-- ----------------------------
-- View structure for wuwtupdatescore
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtupdatescore";
CREATE VIEW "wuwt"."wuwtupdatescore" AS  SELECT tc.wuwtteacherid, s.wuwtstudentid, s.wuwtstudentname, c.wuwtcourseid, 
    c.wuwtcoursename, sc.wuwtsemester, sc.wuwtscore
   FROM wuwt.wuwtteacher_courses tc
   JOIN wuwt.wuwtscores sc ON tc.wuwtcourseid = sc.wuwtcourseid AND tc.wuwtsemester::bpchar = sc.wuwtsemester
   JOIN wuwt.wuwtcourses c ON sc.wuwtcourseid = c.wuwtcourseid
   JOIN wuwt.wuwtstudents s ON sc.wuwtstudentid = s.wuwtstudentid;

-- ----------------------------
-- View structure for wuwtteach
-- ----------------------------
DROP VIEW IF EXISTS "wuwt"."wuwtteach";
CREATE VIEW "wuwt"."wuwtteach" AS  SELECT t.wuwtteacherid, t.wuwtteachername, tc.wuwtcourseid, c.wuwtcoursename, 
    t.wuwttitle, tc.wuwtsemester
   FROM wuwt.wuwtteachers t
   JOIN wuwt.wuwtteacher_courses tc ON t.wuwtteacherid = tc.wuwtteacherid
   JOIN wuwt.wuwtcourses c ON tc.wuwtcourseid = c.wuwtcourseid;

-- ----------------------------
-- Primary Key structure for table wuwtadmin_accounts
-- ----------------------------
ALTER TABLE "wuwt"."wuwtadmin_accounts" ADD CONSTRAINT "wuwtadmin_accounts_pkey" PRIMARY KEY ("wuwtadminname");

-- ----------------------------
-- Primary Key structure for table wuwtbasicinfo
-- ----------------------------
ALTER TABLE "wuwt"."wuwtbasicinfo" ADD CONSTRAINT "wuwtbasicinfo_pkey" PRIMARY KEY ("wuwtstudentid");

-- ----------------------------
-- Indexes structure for table wuwtclass
-- ----------------------------
CREATE UNIQUE INDEX "idx_wuwtclassid" ON "wuwt"."wuwtclass" USING btree (
  "wuwtclassid" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table wuwtclass
-- ----------------------------
ALTER TABLE "wuwt"."wuwtclass" ADD CONSTRAINT "wuwtclass_pkey" PRIMARY KEY ("wuwtclassid");

-- ----------------------------
-- Indexes structure for table wuwtcourses
-- ----------------------------
CREATE UNIQUE INDEX "idx_wuwtcourseid" ON "wuwt"."wuwtcourses" USING btree (
  "wuwtcourseid" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Checks structure for table wuwtcourses
-- ----------------------------
ALTER TABLE "wuwt"."wuwtcourses" ADD CONSTRAINT "wuwtcourses_wuwtcoursehours_check" CHECK ((wuwtcoursehours > 0));
ALTER TABLE "wuwt"."wuwtcourses" ADD CONSTRAINT "wuwtcourses_wuwtcoursecredits_check" CHECK ((wuwtcoursecredits > (0)::double precision));
ALTER TABLE "wuwt"."wuwtcourses" ADD CONSTRAINT "wuwtcourses_wuwtassessmentmethod_check" CHECK (((wuwtassessmentmethod = '考试'::bpchar) OR (wuwtassessmentmethod = '考查'::bpchar)));

-- ----------------------------
-- Primary Key structure for table wuwtcourses
-- ----------------------------
ALTER TABLE "wuwt"."wuwtcourses" ADD CONSTRAINT "wuwtcourses_pkey" PRIMARY KEY ("wuwtcourseid");

-- ----------------------------
-- Indexes structure for table wuwtmajors
-- ----------------------------
CREATE UNIQUE INDEX "idx_wuwtmajorid" ON "wuwt"."wuwtmajors" USING btree (
  "wuwtmajorid" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table wuwtmajors
-- ----------------------------
ALTER TABLE "wuwt"."wuwtmajors" ADD CONSTRAINT "wuwtmajors_pkey" PRIMARY KEY ("wuwtmajorid");

-- ----------------------------
-- Indexes structure for table wuwtscores
-- ----------------------------
CREATE UNIQUE INDEX "idx_wuwtstudentid_courseid_semester" ON "wuwt"."wuwtscores" USING btree (
  "wuwtstudentid" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST,
  "wuwtcourseid" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST,
  "wuwtsemester" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Checks structure for table wuwtscores
-- ----------------------------
ALTER TABLE "wuwt"."wuwtscores" ADD CONSTRAINT "wuwtscores_wuwtscore_check" CHECK (((wuwtscore >= (0)::double precision) AND (wuwtscore <= (100)::double precision)));

-- ----------------------------
-- Primary Key structure for table wuwtscores
-- ----------------------------
ALTER TABLE "wuwt"."wuwtscores" ADD CONSTRAINT "wuwtscores_pkey" PRIMARY KEY ("wuwtstudentid", "wuwtcourseid", "wuwtsemester");

-- ----------------------------
-- Indexes structure for table wuwtstudents
-- ----------------------------
CREATE UNIQUE INDEX "idx_wuwtstudentid" ON "wuwt"."wuwtstudents" USING btree (
  "wuwtstudentid" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Triggers structure for table wuwtstudents
-- ----------------------------
CREATE TRIGGER "wuwttrigger_create_student_account" AFTER INSERT ON "wuwt"."wuwtstudents"
FOR EACH ROW
EXECUTE PROCEDURE "wuwt"."wuwtauto_create_student_account"();
CREATE TRIGGER "wuwttrigger_delete_student_admin" AFTER DELETE ON "wuwt"."wuwtstudents"
FOR EACH ROW
EXECUTE PROCEDURE "wuwt"."wuwtfn_delete_student_admin"();

-- ----------------------------
-- Checks structure for table wuwtstudents
-- ----------------------------
ALTER TABLE "wuwt"."wuwtstudents" ADD CONSTRAINT "wuwtstudents_wuwtgender_check" CHECK (((wuwtgender = '男'::bpchar) OR (wuwtgender = '女'::bpchar)));

-- ----------------------------
-- Primary Key structure for table wuwtstudents
-- ----------------------------
ALTER TABLE "wuwt"."wuwtstudents" ADD CONSTRAINT "wuwtstudents_pkey" PRIMARY KEY ("wuwtstudentid");

-- ----------------------------
-- Primary Key structure for table wuwtteacher_courses
-- ----------------------------
ALTER TABLE "wuwt"."wuwtteacher_courses" ADD CONSTRAINT "wuwtteacher_courses_pkey" PRIMARY KEY ("wuwtcourseid", "wuwtsemester", "wuwtclassid");

-- ----------------------------
-- Indexes structure for table wuwtteachers
-- ----------------------------
CREATE UNIQUE INDEX "idx_wuwtteacherid" ON "wuwt"."wuwtteachers" USING btree (
  "wuwtteacherid" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Triggers structure for table wuwtteachers
-- ----------------------------
CREATE TRIGGER "wuwttrigger_create_teacher_account" AFTER INSERT ON "wuwt"."wuwtteachers"
FOR EACH ROW
EXECUTE PROCEDURE "wuwt"."wuwtauto_create_teacher_account"();
CREATE TRIGGER "wuwttrigger_delete_teacher_admin" AFTER DELETE ON "wuwt"."wuwtteachers"
FOR EACH ROW
EXECUTE PROCEDURE "wuwt"."wuwtfn_delete_teacher_admin"();

-- ----------------------------
-- Checks structure for table wuwtteachers
-- ----------------------------
ALTER TABLE "wuwt"."wuwtteachers" ADD CONSTRAINT "wuwtteachers_wuwtteachergender_check" CHECK (((wuwtteachergender = '男'::bpchar) OR (wuwtteachergender = '女'::bpchar)));
ALTER TABLE "wuwt"."wuwtteachers" ADD CONSTRAINT "wuwtteachers_wuwttitle_check" CHECK (((((wuwttitle)::text = '教授'::text) OR ((wuwttitle)::text = '副教授'::text)) OR ((wuwttitle)::text = '讲师'::text)));

-- ----------------------------
-- Primary Key structure for table wuwtteachers
-- ----------------------------
ALTER TABLE "wuwt"."wuwtteachers" ADD CONSTRAINT "wuwtteachers_pkey" PRIMARY KEY ("wuwtteacherid");

-- ----------------------------
-- Foreign Keys structure for table wuwtbasicinfo
-- ----------------------------
ALTER TABLE "wuwt"."wuwtbasicinfo" ADD CONSTRAINT "wuwtbasicinfo_wuwtstudentid_fkey" FOREIGN KEY ("wuwtstudentid") REFERENCES "wuwt"."wuwtstudents" ("wuwtstudentid") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table wuwtclass
-- ----------------------------
ALTER TABLE "wuwt"."wuwtclass" ADD CONSTRAINT "pk_cla" FOREIGN KEY ("wuwtmajorid") REFERENCES "wuwt"."wuwtmajors" ("wuwtmajorid") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table wuwtscores
-- ----------------------------
ALTER TABLE "wuwt"."wuwtscores" ADD CONSTRAINT "wuwtscores_wuwtcourseid_fkey" FOREIGN KEY ("wuwtcourseid") REFERENCES "wuwt"."wuwtcourses" ("wuwtcourseid") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "wuwt"."wuwtscores" ADD CONSTRAINT "wuwtscores_wuwtstudentid_fkey" FOREIGN KEY ("wuwtstudentid") REFERENCES "wuwt"."wuwtstudents" ("wuwtstudentid") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table wuwtstudents
-- ----------------------------
ALTER TABLE "wuwt"."wuwtstudents" ADD CONSTRAINT "pk_stu" FOREIGN KEY ("wuwtclassid") REFERENCES "wuwt"."wuwtclass" ("wuwtclassid") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table wuwtteacher_courses
-- ----------------------------
ALTER TABLE "wuwt"."wuwtteacher_courses" ADD CONSTRAINT "wuwtteacher_courses_wuwtclassid_fkey" FOREIGN KEY ("wuwtclassid") REFERENCES "wuwt"."wuwtclass" ("wuwtclassid") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "wuwt"."wuwtteacher_courses" ADD CONSTRAINT "wuwtteacher_courses_wuwtcourseid_fkey" FOREIGN KEY ("wuwtcourseid") REFERENCES "wuwt"."wuwtcourses" ("wuwtcourseid") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "wuwt"."wuwtteacher_courses" ADD CONSTRAINT "wuwtteacher_courses_wuwtteacherid_fkey" FOREIGN KEY ("wuwtteacherid") REFERENCES "wuwt"."wuwtteachers" ("wuwtteacherid") ON DELETE CASCADE ON UPDATE CASCADE;
