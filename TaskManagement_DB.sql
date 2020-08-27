--create database TaskManagement_DB_JAVA
/****** Object:  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TeamMember_tbl](
	[id] [int] IDENTITY(100,1) NOT NULL,
	[Name] [varchar](20)NOT NULL,
	[Email] [varchar](50) NULL,
	[Rating] [int]NULL

 CONSTRAINT [PK_TeamMember_tbl] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

------------------------------------------------------------------------------
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Status_tbl](
	[StatusId] [int] IDENTITY(1,1)NOT NULL,
	[StatusName] [varchar](20) NOT NULL
	
 CONSTRAINT [PK_Status_tbl] PRIMARY KEY CLUSTERED 
(
	[StatusId] ASC
	
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
---------------------------------------------------------
GO
SET ANSI_PADDING OFF
GO
/****** Object:   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Task_tbl](
	[TaskId] [int] IDENTITY(1000,1) NOT NULL,
	[Description] [varchar](100) NOT NULL,
	[StatusId] [int]NOT NULL,
	[MemberId] [int]not NULL,
	[WorkingHours][int] NOT NULL,
	[StartDate] [DATE] NOT NULL,
	[EndData][DATE]  NULL
CONSTRAINT FK_member_task Foreign Key ([MemberId]) references [TeamMember_tbl](id),
CONSTRAINT FK_status_task Foreign Key ([StatusId]) references [Status_tbl]([StatusId]),
 CONSTRAINT [PK_task_tbl] PRIMARY KEY CLUSTERED 
(
	[TaskId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
------------------------------------------------------------

SET IDENTITY_INSERT [dbo].[TeamMember_tbl] ON 
INSERT [dbo].[TeamMember_tbl] ([id], [Name], [Email], [Rating]) VALUES (100,'David', 'david@gmail.com',3)
INSERT [dbo].[TeamMember_tbl] ([id], [Name], [Email], [Rating]) VALUES (101,'Dani','Dani@gmail.com',2)
INSERT [dbo].[TeamMember_tbl] ([id], [Name], [Email], [Rating]) VALUES (102, 'Eli', 'Eli@gmail.com',1)
INSERT [dbo].[TeamMember_tbl] ([id], [Name], [Email]) VALUES (103,'Avraham','Avraham@gmail.com')
SET IDENTITY_INSERT [dbo].[TeamMember_tbl] OFF 

SET IDENTITY_INSERT [dbo].[Status_tbl] ON
INSERT [dbo].[Status_tbl] ( [StatusId], [StatusName]) VALUES (1,'New' )
INSERT [dbo].[Status_tbl] ( [StatusId], [StatusName]) VALUES (2,'InProgress')
INSERT [dbo].[Status_tbl] ( [StatusId], [StatusName]) VALUES (3, 'Done')
SET IDENTITY_INSERT [dbo].[Status_tbl] OFF


SET IDENTITY_INSERT [dbo].[Task_tbl] ON
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate],[EndData]) VALUES (1000,'',3, 100,120,'2020-01-10','2020-01-19')
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate],[EndData]) VALUES (1001, '',3,102,100,'2020-03-25','2020-04-05')
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate]) VALUES (1002, '',2,101,250, '2020-07-04')
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate]) VALUES (1003, '',1,101,300,'2020-07-01')
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate],[EndData]) VALUES (1004,'',3, 100,220,'2020-01-17','2020-02-15')
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate],[EndData]) VALUES (1005, '',3,102,100,'2020-03-25','2020-04-05')
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate]) VALUES (1006, '',2,103,250, '2020-06-20')
INSERT [dbo].[Task_tbl] ([TaskId], [Description], [StatusId], [MemberId],[WorkingHours],[StartDate]) VALUES (1007, '',1,103,70,'2020-07-30')
SET IDENTITY_INSERT [dbo].[Task_tbl] OFF



GO
