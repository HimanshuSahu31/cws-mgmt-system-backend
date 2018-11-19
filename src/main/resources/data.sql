-- Sample Data Entry for Testing

-- User
INSERT INTO public.tb_user(user_type, user_dob, user_email, user_fname, user_id_proof, user_lname, user_mname, user_password, user_phone, user_status, user_username, user_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

-- Address
INSERT INTO public.tb_address(address_line_one, address_line_two, address_line_three, address_area, address_city, address_country, address_pincode, address_state) VALUES ('line 1', 'line 2', 'line 3', 'area511', 'city171', 'countryboy1','3800541', 'squalor1');
INSERT INTO public.tb_address(address_line_one, address_line_two, address_line_three, address_area, address_city, address_country, address_pincode, address_state) VALUES ('line 4', 'line 5', 'line 6', 'area512', 'city172', 'countryboy2','3800542', 'squalor2');
INSERT INTO public.tb_address(address_line_one, address_line_two, address_line_three, address_area, address_city, address_country, address_pincode, address_state) VALUES ('line 7', 'line 8', 'line 9', 'area513', 'city173', 'countryboy3','3800543', 'squalor3');

-- Issue Type
INSERT INTO public.tb_issue_type(issue_type_name, issue_type_priority) VALUES ('no fans working', 'high');
INSERT INTO public.tb_issue_type(issue_type_name, issue_type_priority) VALUES ('payment not transferring', 'very high');
INSERT INTO public.tb_issue_type(issue_type_name, issue_type_priority) VALUES ('ro filter broken', 'medium');

-- Issue