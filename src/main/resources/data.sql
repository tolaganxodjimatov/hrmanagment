insert into role(id,role_name)
values   (1,'ROLE_ADMIN_DIREKTOR'),
         (2,'ROLE_MODER_HR_MANAGER'),
         (3,'ROLE_USER_EMPLOYEE');


 INSERT INTO public.user_employee (
                account_non_expired,
                account_non_locked,
                created_at,
                credentials_non_expired,
                email,
                email_code,
                enabled,
                full_name,
                password,
                updated_at,
                id)
            VALUES (
                true::boolean,
                true::boolean,
                now()::timestamp without time zone,
--                 '2022-02-12 16:02:44.885'::timestamp without time zone,
                true::boolean,
                'direktor@mail.ru'::character varying,
                null,
                true::boolean,
                'direktor'::character varying,
                '$2a$10$w2aXg6gu6Dzf5EkRWkVvr.PNLoHX6E2faHjlatKEEhHk6LNayehtC'::character varying,
                '2022-02-12 16:02:44.884'::timestamp without time zone,
                '93fda50f-d23d-47a1-95df-f4b6b2ef88f9'::uuid);