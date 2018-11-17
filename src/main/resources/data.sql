-- Address


-- User
INSERT INTO public.tb_user(user_type, user_dob, user_email, user_fname, user_id_proof, user_lname, user_mname, user_phone, user_status, user_address) 
VALUES ('Admin', '15/11/1996', 'a.a@a', 'ad', 'm', 'in', ?, '12346540', true, 1);

-- Admin


-- Issue Type
INSERT INTO public.tb_issue_type(issue_type_name, issue_type_priority) VALUES ('No chairs', 3);
INSERT INTO public.tb_issue_type(issue_type_name, issue_type_priority) VALUES ('No tables', 4);
INSERT INTO public.tb_issue_type(issue_type_name, issue_type_priority) VALUES ('No Receptionist', 5);

-- Issue
INSERT INTO public.tb_issue(issue_desc, issue_status, issue_admin, issue_type_id) VALUES ('no chairs man', 'unseen', 1, 3);
INSERT INTO public.tb_issue(issue_desc, issue_status, issue_admin, issue_type_id) VALUES (?, ?, ?, ?);
INSERT INTO public.tb_issue(issue_desc, issue_status, issue_admin, issue_type_id) VALUES (?, ?, ?, ?);
INSERT INTO public.tb_issue(issue_desc, issue_status, issue_admin, issue_type_id) VALUES (?, ?, ?, ?);
INSERT INTO public.tb_issue(issue_desc, issue_status, issue_admin, issue_type_id) VALUES (?, ?, ?, ?);