for flag in '<actedIn>' '<hasAcademicAdvisor>' '<hasChild>' '<hasFamilyName>' '<hasWebsite>' '<hasWonPrize>' '<isInterestedIn>' '<isKnownFor>' '<directed>' '<edited>' '<graduatedFrom>' '<hasGender>' '<hasMusicalRole>' '<isCitizenOf>' '<isMarriedTo>' '<isPoliticianOf>' '<playsFor>' '<worksAt>' '<wroteMusicFor>' '<created>' '<diedIn>' '<hasGivenName>' '<influences>' '<isAffiliatedTo>' '<isLeaderOf>' '<livesIn>' '<owns>' '<participatedIn>' '<wasBornIn>';
do
	hive -e "INSERT INTO TABLE yago_part_buck PARTITION (predicate='$flag') SELECT * FROM yago WHERE predicate = '$flag';"
done
